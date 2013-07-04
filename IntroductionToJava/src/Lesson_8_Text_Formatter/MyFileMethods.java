package Lesson_8_Text_Formatter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mike
 */
public class MyFileMethods {

    Scanner input = new Scanner(System.in);

    /**
     * A fun method that takes a file path and returns a nicely formatted string
     *
     * @param inputFile the string representing the input file path.
     * @param lineLength the maximum number of chars to be included in one line
     * @return a String that represents the formatted file
     */
    public String FormatFileToString(String inputFile, int lineLength) {
	// using buffered reader as opposed to scanner
	BufferedReader br = null;
	StringBuilder output = new StringBuilder();

	try {
	    String currentLine;


	    br = new BufferedReader(new FileReader(inputFile));

	    int currLineLength = 0;

	    // read each line till the end of the file
	    while ((currentLine = br.readLine()) != null) {
		// split current line by space regex into array of words
		// the + indicates that I want to split by one of the given types listed
		String[] tempList = currentLine.split("[ \t\n]+");

		// The actual formatting portion
		// loop through current line of text and add words to stringbuilder		
		for (String word : tempList) {

		    // if the length of the current word plus the current line length is greater than the specified line length
		    // it will split the line and continue on the next line
		    if ((currLineLength + word.length()) > lineLength) {

			boolean lineOk = false;
			while (!lineOk) {
			    if (word.length() > lineLength) {
				// split the word and add it the next line.
				String tempLine = word.substring(0, Math.abs(lineLength - currLineLength));
				output.append(tempLine);
				output.append("\n");
				// create a second word out of the remaining string
				String tempLine2 = word.substring(Math.abs(lineLength - currLineLength));
				// current line length is the size of the second half of the split
				currLineLength = tempLine2.length();

				// if the split section is STILL to long				
				if (currLineLength > lineLength) {
				    // reset the word to be the new section
				    word = tempLine2;
				    lineOk = false; // repeat
				} else {
				    output.append(tempLine2); // finally add temp2
				    lineOk = true;
				}

			    } else {
				lineOk = true;
				output.append("\n");
				output.append(word);
				output.append(" ");
				currLineLength = word.length() + 1; // reset line length
			    }

			}

		    } else {
			output.append(word);
			output.append(" ");
			currLineLength += word.length(); // to keep accurate line length
			currLineLength++; // to account for the space that will follow
		    }
		}
	    }	    
	    br.close();
	} catch (IOException e) {
	    System.err.println(e.getMessage());
	}

	return output.toString();
    }

    /**
     * Saves a given string to a given file as a .txt file
     *
     * @param fileName the name or path represented as a string of the output
     * file
     * @param stringInput the data to be written to the file as one string
     */
    public void SaveStringToFile(String fileName, String stringInput) {
	//using a relative file path.
	File file = new File(fileName);

	// ADD PROMPT TO OVERWRITE!!!!
	
	
	// START FIXING HERE.
	// add overwrite stuff in the main method with input file stuff.
	
	
	
	
	
	
	try {
	    // check for file existance and prompt for overwrite if it does
	    while (file.exists()) {
		System.err.print("File Exists. Overwrite? (y/n) -> ");
		String overwriteCondition = input.nextLine();
		// if they enter yes or no to overwriting file
		if (overwriteCondition.equals("y") || overwriteCondition.equals("Y")) {
		    file.delete(); // remove file		   
		} else {
		    fileName = NewFileName("New Output"); // sets new fileName
		}
	    }

	    // finally create the stupid file.
	    file.createNewFile();

	    //create buffered output stream
	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);

	    bw.write(stringInput); //actually write to file.

	    bw.close(); //close I/O stream.

	} catch (IOException ioe) {
	    System.err.println(ioe.getMessage());
	}

	System.out.println("Output written to: " + file.getAbsolutePath());
    }

    /**
     * Prompts the user to input a filename or path.
     *
     * @param type indcates the type of input file either input or output.
     * @return a String of the new file name
     */
    public String NewFileName(String type) {
	System.out.print(type + " File name -> ");
	String outputFileName = input.nextLine();
	return outputFileName;
    }
}
