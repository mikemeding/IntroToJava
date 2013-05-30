

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mike Meding
 */
public class URLLesson {
/*
 * Professor, 
 *    As a response to your last message on my assignment about
 * taking a higher level course, as much as I would love to take
 * a higher level course it happens that the college that I am at 
 * currently requres that I take this intro class. It also happens
 * that this class is the very last requrement for me to recieve 
 * my degree. I happened to skip it when I first started school 
 * thinking that subsequent classes would make up for it (My
 * counciler even said it was fine). Needless to say I was wrong.
 *    Therefore, I would like to inquire if it is possible to 
 * recieve the assignments in advance so that may be able to
 * finish sooner.
 * 
 * - Mike Meding.
 * 
 */


    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	// Variables
	StringBuilder output = new StringBuilder();
	StringBuilder save = new StringBuilder();
	save.append("***URL TRANSLATOR OUTPUT***\n"); // output file heading.
	int x;

	while (true) {
	    // Input prompt
	    System.out.print("URL: ");
	    String input = in.nextLine();
	    System.out.println("Input URL: " + input);


	    // Generating ignore char list
	    // Values 0-9
	    ArrayList<Character> ignore = new ArrayList<Character>();
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

	    
	    /* THE ACTUAL CODE FROM THE ASSIGNMENT... */ 
	    char inputChar = ' ';
	    for (x = 0; x < input.length(); x++) {
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
	    System.out.println("output URL: " + output.toString());



	    // Creating output file format.
	    save.append("Input URL: ");
	    save.append(input);
	    save.append("\n");
	    save.append("Output URL: ");
	    save.append(output.toString());
	    save.append("\n");
	    
	    
	    System.out.print("Again?(y/n): ");
	    String again = in.nextLine();
	    if("y".equals(again) || "Y".equals(again)){	
		output.setLength(0); // resetting output StringBuilder 
		continue;
	    }else{
		break;
	    }
	}
	SaveStringToFile(save.toString());

    }

    public static void SaveStringToFile(String input) {
	//using a relative file path.
	File file = new File("output.txt");

	try {
	    // if file doesnt exists, then create it.
	    // otherwise remove the file and create a new one.
	    if (!file.exists()) {
		file.createNewFile();
	    } else {
		file.delete();
		file.createNewFile();
	    }

	    //create buffered output stream
	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);

	    bw.write(input); //actually write to file.

	    bw.close(); //close I/O stream.

	} catch (IOException ioe) {
	    System.err.println(ioe.getMessage());
	}

	System.out.println("Output written to: " + file.getAbsolutePath());
    }
}
