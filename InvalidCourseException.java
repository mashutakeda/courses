/**
 * This class describes an unchecked exception InvalidCourseException.
 *
 * @author Mashu Takeda mtakeda9
 * @version 1
 */
public class InvalidCourseException extends RuntimeException {
    /**
     * A constructor that takes in a String representing the exception’s message.
     * @param message the message printed out for the specified course
     *                (computer science, lab science).
     */
    public InvalidCourseException(String message) {
        super(message);
    }

    /**
     * A no-args constructor that has the default message "Invalid course type!".
     */
    public InvalidCourseException() {
        super("Invalid course type!");
    }
}
