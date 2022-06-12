/**
 * This class represents a Course, and it is an abstract class.
 *
 * @author Mashu Takeda mtakeeda9
 * @version 1
 */
public abstract class Course {
    protected String courseName;
    protected int id;
    protected String professorName;

    /**
     * A constructor that takes in courseName, id, and professorName.
     *
     * @param courseName    the name of the course
     * @param id            the course identification number
     * @param professorName the name of the professor
     */
    public Course(String courseName, int id, String professorName) {
        if (courseName.equals("") || professorName.equals("") || courseName == null || professorName == null) {
            throw new IllegalArgumentException();
        } else if (id < 0 || Integer.toString(id).length() != 5) {
            throw new IllegalArgumentException();
        } else {
            this.courseName = courseName;
            this.id = id;
            this.professorName = professorName;
        }

    }

    @Override
    public String toString() {
        return String.format("%s,%d,%s", courseName, id, professorName);
    }

    @Override
    public boolean equals(Object o) {
        boolean equal = false;
        if (o == null) {
            equal = false;
        } else if (o instanceof Course) {
            equal = this.courseName.equals(((Course) o).courseName)
                && this.id == ((Course) o).id
                && this.professorName.equals(((Course) o).professorName);
        }
        return equal;
    }
}