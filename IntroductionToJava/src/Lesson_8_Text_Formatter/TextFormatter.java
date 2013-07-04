package Lesson_8_Text_Formatter;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mike
 */
public class TextFormatter {
    //Instance variables

    static Scanner input = new Scanner(System.in);
    static File inputFile;
    static MyFileMethods mFm = new MyFileMethods();

    public static void main(String[] args) {		

	//loops till it gets a valid file name
	boolean correctInput = false;
	String inputFileName = "default.txt";

	while (!correctInput) {

	    //User input prompt	    
	    inputFileName = mFm.NewFileName("Input");	    

	    //Testing to see if the file exists.
	    try {
		//create file to check for existance
		inputFile = new File(inputFileName);

		if (inputFile.exists()) {

		    //System.out.println("Found file"); //remove this later
		    correctInput = true;

		} else {
		    throw new Exception("File not found. Try again.");
		}

	    } catch (Exception e) {
		//print error message
		System.err.println(e.getMessage());
	    }
	}

	// Prompting user for valid line length input
	correctInput = false;
	int lineLength = 0;
	String temp = "";
	while (!correctInput) {
	    try {
		System.out.print("Line Length (30-100) -> ");
		temp = input.nextLine();
		// parse input to int. will also throw NumberFormatException if incorrect
		lineLength = Integer.parseInt(temp);

		
		// must be between 30 and 100		
		if (lineLength >= 30 && lineLength <= 100) {
		    correctInput = true;				    
		} else {
		    throw new NumberFormatException("Number out of range. (30-100)");
		}		
	    } catch (NumberFormatException nfe) {
		System.err.println(nfe.getMessage());
		correctInput = false;
	    }
	}
	
	// getting output file name
	String outputFileName = "default.txt";	
	outputFileName = mFm.NewFileName("Output");
	
	String formattedText = mFm.FormatFileToString(inputFileName, lineLength);	
	
	// add line of * to show what the correct line width should be.
	int x;
	for(x = 0; x < lineLength; x++)
	System.out.print("*");
		
	System.out.println("\n"+formattedText);
		
	



    }// end of main()
}// end of TextFormatter class
