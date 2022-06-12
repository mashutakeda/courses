/**
 * This class represents a lab science and is a concrete implementation of Course.
 *
 * @author Mashu Takeda mtakeda9
 * @version 1
 */
public class LabScience extends Course {
    private boolean labCoatRequired;

    /**
     * A constructor that takes in courseName, id, professorName, and labCoatRequired.
     *
     * @param courseName      the name of the course
     * @param id              identification number for the course
     * @param professorName   professor's name for the course
     * @param labCoatRequired if the lab coat is required for the course
     */
    public LabScience(String courseName, int id, String professorName, boolean labCoatRequired) {
        super(courseName, id, professorName);
        this.labCoatRequired = labCoatRequired;
    }

    @Override
    public String toString() {
        return "LabScience," + super.toString() + "," + labCoatRequired;
    }

    @Override
    public boolean equals(Object o) {
        return (super.equals(o) && this.labCoatRequired == ((LabScience) o).labCoatRequired);
    }

}