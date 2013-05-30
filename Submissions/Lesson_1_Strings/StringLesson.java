

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mike
 */
public class StringLesson {
    /*     
    Write your first Java program to do the following:

    Prompt the user to enter a line of text containing 'java'
    Read the line of text  (using the Scanner class nextLine method).
    Print the line of text entered.
    Print the number of characters in the line (use the String class length() method)
    Print the line in lowercase (use the String class toLowerCase() method)
    Print the line in uppercase (use the String class toUpperCase() method)
    Locate the first occurance of 'java' (use the String class indexOf() method), print the position value, and save it in a variable for the next step 
    Print the line with 'java' changed to 'Java'.  
    Note: use the String class substring() method to get the text before 'java', and again to get the text after 'java', then print the result of concatenating before-text + "Java" + after-text. You'll' need to use the position variable saved in the previous step when calling substring.
    Print the line with 'java' changed to 'JAVA' (use the same logic as the previous step)
    */

    public static void main(String[] args) {

	Scanner is = new Scanner(System.in);
	String input = null;
	StringBuilder save = new StringBuilder();

	while (true) {
	    System.out.print("Enter a sting. Enter ~ to exit. : ");
	    input = is.nextLine();

	    //checking exit parameter
	    if ("~".equals(input)) {
		break;
	    }
	    
	    //string reformatting to standard output.   	    	    
	    System.out.println("The string read is: " + input);
	    System.out.println("Length in chars is: " + input.length());
	    System.out.println("All lowercase is: " + input.toLowerCase());
	    System.out.println("All uppercase is: " + input.toUpperCase());
	    System.out.println("Found 'java' at pos: " + input.indexOf("java"));
	    System.out.println("Changing to 'Java': " + input.replace("java", "Java"));	    
	    System.out.println("Changing to 'JAVA': " + input.replace("java", "JAVA"));
	    System.out.println();
	    
	    //concatenating to be saved.
	    save.append("The string read is: ").append(input);
	    save.append("\n");
	    save.append("Length in chars is: ").append(input.length());
	    save.append("\n");    
	    save.append("All lowercase is: ").append(input.toLowerCase());
	    save.append("\n");
	    save.append("All uppercase is: ").append(input.toUpperCase());
	    save.append("\n");
	    save.append("Found 'java' at pos: ").append(input.indexOf("java"));
	    save.append("\n");
	    save.append("Changing to 'Java': ").append(input.replace("java", "Java"));
	    save.append("\n");	    
	    save.append("Changing to 'JAVA': ").append(input.replace("java", "JAVA"));
	    save.append("\n");
	    save.append("\n"); // to separate outputs.

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
