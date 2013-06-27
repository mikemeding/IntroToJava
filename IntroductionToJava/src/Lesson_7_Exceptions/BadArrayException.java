/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson_7_Exceptions;

/**
 *
 * @author mike
 */
public class BadArrayException extends Exception {

    public BadArrayException() {
    }

    public BadArrayException(String message) {
        super(message);
    }
    
}
