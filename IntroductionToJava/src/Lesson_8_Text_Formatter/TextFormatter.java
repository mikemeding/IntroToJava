package Lesson_8_Text_Formatter;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author mike
 */
public class TextFormatter {
    //Instance variables

    static Scanner input = new Scanner(System.in);
    static File inputFile;
    static File outputFile;
    static MyFileMethods mFm = new MyFileMethods();

    public static void main(String[] args) {

        /**
         * INPUT FILE*
         */
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

        /**
         * LINE LENGTH*
         */
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

        /**
         * OUTPUT FILE*
         */
        //loops till it gets a valid file name
        correctInput = false;
        String outputFileName = "default.txt";

        while (!correctInput) {

            //User input prompt	    
            outputFileName = mFm.NewFileName("Output");

            //Testing to see if the file exists.
            try {
                //create file to check for existance
                outputFile = new File(outputFileName);

                if (outputFile.exists()) {

                    //System.out.println("Found file"); //remove this later
                    System.out.print("File exists. Would you like to overwrite? (y/n): ");
                    String overwrite = input.nextLine();
                    if (overwrite.equals("y") || overwrite.equals("Y")) {
                        // removes file if it exists
                        outputFile.delete();
                        outputFile.createNewFile();
                        correctInput = true;
                    } else {
                        outputFileName = mFm.NewFileName("Output");
                        correctInput = false;
                        continue;
                    }

                } else {
                    outputFile.createNewFile();
                    break;
                }

            } catch (Exception e) {
                //print error message
                System.err.println(e.getMessage());
            }
        }

        // Most important line of this program.       
        String formattedText = mFm.FormatFileToString(inputFileName, lineLength);

        // The final output of this program
        StringBuilder endingString = new StringBuilder();

        // add line of * to show what the correct line width should be.
        int x;
        for (x = 0; x < lineLength; x++) {
            endingString.append("*");
        }
        // final formatting.
        endingString.append("\n");
        endingString.append(formattedText);
        endingString.append("\n");

        // print out the entire file
        //System.out.println(endingString.toString());
                
        // actually saves the formatted string to the specified file.        
        mFm.SaveStringToFile(outputFile.toString(), endingString.toString());









    }// end of main()
}// end of TextFormatter class
