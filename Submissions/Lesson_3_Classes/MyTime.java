

/**
 * MyTime - a simple time class
 *
 * Add code to replace the temporary 'return' statements in the methods, and
 * additional parameter checking code in the setTime method, etc. The temporary
 * 'return' statements are needed to compile OK until you replace them with the
 * actual code.
 */
public class MyTime {
    // Instance variables holding the time (in 24 hour universal form).

    private int mHour;      // 0 - 23
    private int mMinute;    // 0 - 59
    private int mSecond;    // 0 - 59

    /**
     * Sets the time value for this MyTime object. If *any* of the parameter
     * values are out of range, the time is set to 00:00:00.
     *
     * @param hour the hour (0 to 23).
     * @param minute the minute (0 to 59).
     * @param second the second (0 to 59).
     */
    public void setTime(int hour, int minute, int second) {
	// TODO - add parameter checking code, and set the instance variables.
	// If any of the parameters are out of range, set all the instance variables to zero.

	// the nested if statement from hell.
	if (hour > 23 || hour < 0) {
	    this.mHour = 0;
	    this.mMinute = 0;
	    this.mSecond = 0;
	} else {
	    if (minute > 59 || minute < 0) {
		this.mHour = 0;
		this.mMinute = 0;
		this.mSecond = 0;
	    } else {
		if (second > 59 || second < 0) {
		    this.mHour = 0;
		    this.mMinute = 0;
		    this.mSecond = 0;
		} else {
		    this.mHour = hour;
		    this.mMinute = minute;
		    this.mSecond = second;
		}
	    }
	}

    }

    /**
     * Returns the hour value represented by this MyTime.
     *
     * @return the hour value of this object as an int.
     */
    public int getHour() {
	return this.mHour;
    }

    /**
     * Returns the minute value represented by this MyTime.
     *
     * @return the minute value of this object as an int.
     */
    public int getMinute() {
	return this.mMinute;
    }

    /**
     * Returns the second value represented by this MyTime.
     *
     * @return the second value of this object as an int.
     */
    public int getSecond() {
	return this.mSecond;
    }

    /**
     * Compares this MyTime object against another MyTime object. The result is
     * true if and only if the argument is not null and represents a time that
     * is the same time as represented by this object
     *
     * @param other the object to be compared.
     * @returns true if both objects represent the same time value, false
     * otherwise.
     */
    public boolean equals(MyTime other) {
	// TODO - add code to return 'true' if 'this' MyTime matches
	// the time values in the 'other' MyTime object, else return false.	
	if (this.mHour == other.getHour() && this.mMinute == other.getMinute() && this.mSecond == other.getSecond()) {
	    return true;
	}
	return false;
    }

    /**
     * Returns the time of this MyTime object in HH:MM:SS AM/PM form.
     *
     * @return the time value represented by this object as a String formatted
     * as HH:MM:SS AM/PM .
     */
    public String toString() {
	String result = "";

	// TODO - add code to format the time in the instance variables
	// into HH:MM:SS AM/PM time (hour ranges from 1 to 12, AM or PM)
	// as a string and return it. Call the twoDigits() method to
	// convert each int value to String.
	if (this.mHour < 12) {
	    if (this.mHour == 0) { //because 0 hour is midnight.
		result = 12 + ":" + twoDigits(this.mMinute) + ":" + twoDigits(this.mSecond) + " AM";
		return result;
	    } else {
		result = twoDigits(this.mHour) + ":" + twoDigits(this.mMinute) + ":" + twoDigits(this.mSecond) + " AM";
		return result;
	    }
	} else {
	    if (this.mHour == 12) { // noon is the only time you do not subtract 12 hours from the time.
		result = twoDigits(this.mHour) + ":" + twoDigits(this.mMinute) + ":" + twoDigits(this.mSecond) + " PM";
		return result;
	    } else {
		result = twoDigits(this.mHour - 12) + ":" + twoDigits(this.mMinute) + ":" + twoDigits(this.mSecond) + " PM";
		return result;
	    }
	}
    }

    /**
     * Returns the time of this MyTime object in 24 hour universal form.
     *
     * @return the time value represented by this object as a String formatted
     * as HH:MM:SS universal time.
     */
    public String toUniversalString() {
	String result = "";

	// TODO - add code to format the time in the instance variables
	// into HH:MM:SS universal time (hour ranges from 0 to 23)
	// as a string and return it. Call the twoDigits() method to
	// convert each int value to String.
	result = twoDigits(this.mHour) + ":" + twoDigits(this.mMinute) + ":" + twoDigits(this.mSecond);
	return result;
    }

    /**
     * Returns the parameter value as a two digit String (with leading 0 if
     * needed)
     *
     * @return the parameter 'value' formatted as a two digit String (with
     * leading zero if needed).
     */
    private String twoDigits(int value) {
	String result = "";

	// TODO - Use the Integer.toString(int) method to convert
	// 'value' to String format, and add a leading "0" if
	// value is less than 10 in order to return a string with
	// two digits.
	result = String.format("%02d", value); // -0 fill value -2 string width
	return result;
    }
}
