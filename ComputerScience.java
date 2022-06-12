/**
 * This class describes a computer science course and is a concrete implementation of Course.
 *
 * @author Mashu Takeda mtakeda9
 * @version 1
 */
public class ComputerScience extends Course {
    private String language;

    /**
     * A constructor that takes in courseName, id, professorName, and language.
     *
     * @param courseName    the name of the course
     * @param id            the identification number for the course
     * @param professorName the professor for the course
     * @param language      the language in which the class is taught
     */
    public ComputerScience(String courseName, int id, String professorName, String language) {
        super(courseName, id, professorName);
        if (language == null || language.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.language = language;
        }
    }

    @Override
    public String toString() {
        return "ComputerScience," + super.toString() + "," + language;
    }

    @Override
    public boolean equals(Object o) {
        return (super.equals(o) && this.language.equals(((ComputerScience) o).language));
    }


}