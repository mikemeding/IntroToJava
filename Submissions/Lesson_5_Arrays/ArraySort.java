

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Mike Meding
 */
public class ArraySort {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	String again;
	while (true) {

	    // the actual meat of my main program.
	    int size = getArraySize();
	    int[] array = new int[size];
	    fillArray(array);
	    System.out.println("The unsorted values...");
	    printArray(array);
	    assignmentWayToSort(array);
	    System.out.println("The sorted values....");
	    printArray(array);


	    // just in case someone feels like running it again.
	    System.out.print("Again?(y/n):");
	    again = in.nextLine();
	    if (again.equals("y") || again.equals("Y") || again.equals("yes")) {
		continue;
	    } else {
		break;
	    }
	}
    }

    public static void fillArray(int[] array) {
	int times = 0;
	while (times < array.length) {
	    array[times] = getInt(times + 1);
	    times++;
	}
    }

    public static void printArray(int[] array) {
	for (int x = 0; x < array.length; x++) {
	    System.out.print(array[x] + " "); // cat output onto one line.
	}
	System.out.println(); // a nice blank line :D
    }

    public static void sortArray(int[] array) {
	// This is technically the preferred way to sort small amounts of data in java,
	Arrays.sort(array); // but as this kinda defeats the purpose of this exercise, sooooooo......
    }

    public static void assignmentWayToSort(int[] array) {
	// as according to the assignment this was the described sort algorithm.
	boolean swapped = true;
	int x;
	int temp;

	while (swapped == true) {
	    swapped = false;
	    for (x = 0; x < array.length - 1; x++) {
		if (array[x] > array[x + 1]) {
		    temp = array[x];
		    array[x] = array[x + 1];
		    array[x + 1] = temp;
		    swapped = true;
		}
	    }
	}
    }

    // my own methods. because it seemed more logical this way...
    /**
     * A method to get the size of the array in question.
     * <p>
     * Must be between 3 and 10 elements. unless correct input is given function
     * will not return.
     *
     * @return An int of the correct array size.
     */
    private static int getArraySize() {
	String inputSize;
	int size = 3; // if all goes seriously to hell.

	while (true) {
	    try {
		System.out.print("Enter the size of the array (3 to 10): ");
		inputSize = in.nextLine();
		size = Integer.parseInt(inputSize); // will throw NumberFormatException if not an int...

		if (size < 3 || size > 10) { // personal error checking.
		    throw new NumberFormatException("Value Must be between 3 and 10. Try Again.");
		}
		break;
	    } catch (NumberFormatException nfe) {
		System.err.println("Input incorrect, must be of type [int] and between 3 - 10.");
	    }
	}
	return size;
    }

    /**
     * A method to return an integer. woo. (includes error correction.)
     *
     * @return an Integer.
     */
    private static int getInt(int iter) {
	int numb = 0; // if something goes terribly wrong default = 0
	String input;
	while (true) {
	    try {
		System.out.print("Enter value for element " + iter + ": ");
		input = in.nextLine();
		numb = Integer.parseInt(input); // will throw a number format exception.
		break;
	    } catch (NumberFormatException nfe) {
		System.err.println("Input incorrect, must be of type [int].");
	    }
	}
	return numb;
    }
} //end of program.
