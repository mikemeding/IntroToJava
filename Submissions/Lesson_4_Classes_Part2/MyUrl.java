

import java.util.ArrayList;

/**
 * JavaDoc is awesome. :D
 * @author mike meding
 */
public class MyUrl {

    private String mUrl;
    private static ArrayList<Character> ignore = new ArrayList<Character>();

    public MyUrl(String url) { // constructor of constructingness
	// adds http:// if needed
	if (url.substring(0, 7).equals("http://")) {	    
	    mUrl = url;
	} else {	    
	    mUrl = "http://" + url;
	}

	// Generating ignore char list for encoding
	// Values 0-9
	int y;
	for (y = '0'; y <= '9'; y++) {
	    ignore.add((char) y);
	}
	// Values A-Z
	for (y = 'A'; y <= 'Z'; y++) {
	    ignore.add((char) y);
	}
	// Values a-z
	for (y = 'a'; y <= 'z'; y++) {
	    ignore.add((char) y);
	}
	// Symbols
	ignore.add('_');
	ignore.add('-');
	ignore.add('.');
	ignore.add('*');
    }

    public void addArgument(String name, String value) {
	if (containsQuestion(mUrl)) {
	    mUrl = mUrl + "&" + urlEncode(name) + "=" + urlEncode(value);
	} else {
	    mUrl = mUrl + "?" + urlEncode(name) + "=" + urlEncode(value);
	}
    }

    public void addArgument(String name, int ivalue) {
	if (containsQuestion(mUrl)) {
	    mUrl = mUrl + "&" + urlEncode(name) + "=" + urlEncode(String.valueOf(ivalue));
	} else {
	    mUrl = mUrl + "?" + urlEncode(name) + "=" + urlEncode(String.valueOf(ivalue));
	}
    }

    public void addArgument(String name, double dvalue) {
	if (containsQuestion(mUrl)) {
	    mUrl = mUrl + "&" + urlEncode(name) + "=" + urlEncode(String.valueOf(dvalue));
	} else {
	    mUrl = mUrl + "?" + urlEncode(name) + "=" + urlEncode(String.valueOf(dvalue));
	}
    }

    /**
     * There are better ways of going about this.
     * @deprecated use the getUrl() method instead of calling the overridden toString method.
     * @return a formatted string of the current url.
     */
    @Override
    public String toString() {
	return mUrl;
    }
    /**
     * Whichever method works for you....
     * @return formatted string of the current url. (Same as toString() method)
     */
    public String getUrl(){
	return mUrl;
    }

    /**
     * A method to URL encode text.
     *
     * @param text the text to be encoded
     * @return the String of the URL encoded text
     */
    public static String urlEncode(String text) {
	// Variables
	StringBuilder output = new StringBuilder();
	String input = text;
	char inputChar;

	/* THE ACTUAL CODE FROM THE ASSIGNMENT... */
	for (int x = 0; x < input.length(); x++) {
	    inputChar = input.charAt(x);

	    if (inputChar == ' ') {
		output.append("+");
	    } else if (ignore.contains(inputChar)) {
		output.append(input.charAt(x)); //Input and output remain the same.
	    } else {
		output.append("%");
		output.append(Integer.toHexString(input.charAt(x))); //cat Hex ASCII value
	    }
	}
	return output.toString();

    }

    //My Methods
    /**
     * A method to check for the existance of a ? in a string.
     *
     * @param url the url to check.
     * @return true if the url contains a ?
     */
    private boolean containsQuestion(String url) {
	for (int x = 0; x < url.length(); x++) {
	    if (url.charAt(x) == '?') {
		return true;
	    } else {
		continue;
	    }
	}
	return false;
    }
} // end of MyUrl class
