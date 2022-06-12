import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * This class will hold various public static methods that will let you read and write to the database.
 *
 * @author Mashu Takeda mtakeda9
 * @version 1
 */
public class Classes {
    /**
     * Takes in a String object representing the file name to read from and returns an ArrayList of Course objects.
     *
     * @param filename the name of the file to read from
     * @return arraylist representing course objects
     * @throws FileNotFoundException  if the passed in file is null or doesn’t exist
     * @throws InvalidCourseException if the type of course is not ComputerScience or LabScience
     */
    public static ArrayList<Course> outputCourses(String filename)
        throws FileNotFoundException {
        ArrayList<Course> list = new ArrayList<>();
        File newFile = new File("./" + filename);
        Scanner scanner = new Scanner(newFile);
        if (!newFile.exists() || newFile == null) {
            throw new FileNotFoundException();
        } else {
            while (scanner.hasNextLine()) {
                String aLine = scanner.nextLine();
                String[] array = aLine.split(",");
                if (array[0].equals("ComputerScience")) {
                    ComputerScience csCourse = new ComputerScience(array[1],
                        Integer.valueOf(array[2]), array[3], array[4]);
                    list.add(csCourse);
                } else if (array[0].equals("LabScience")) {
                    LabScience lab = new LabScience(array[1],
                        Integer.valueOf(array[2]), array[3], Boolean.valueOf(array[4]));
                    list.add(lab);
                } else {
                    throw new InvalidCourseException();
                }
            }
            scanner.close();

        }
        return list;
    }

    /**
     * Iterate through the ArrayList and write each Course object to its own line.
     *
     * @param fileName the name of file to read
     * @param courses  arraylist of course objects
     * @return boolean representing whether the write was successful
     * @throws Exception when the course objects don't follow the guideline
     */
    public static boolean writeCourses(String fileName, ArrayList<Course> courses) throws Exception {
        boolean isTrue = false;
        try {
            File myFile = new File(fileName);
            if (myFile.exists()) {
                ArrayList<Course> oldArraylist = outputCourses(fileName);
                PrintWriter printWriter = new PrintWriter(fileName);

                for (Course lines : oldArraylist) {
                    printWriter.write(lines + "\n");
                }
                for (Course line : courses) {
                    printWriter.write(line + "\n");
                    isTrue = true;
                }
                printWriter.close();

            } else {
                PrintWriter printWriter = new PrintWriter(fileName);
                for (Course line : courses) {
                    printWriter.write(line + "\n");
                    isTrue = true;
                }
                printWriter.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isTrue;
    }

    /**
     * Iterates through the file and searches through inputted course objects,
     * and creates an arraylist with found course objects with line numbers.
     *
     * @param filename the file to read
     * @param course   the course objects to find
     * @return an arraylist of integer objects
     * @throws FileNotFoundException  when the passed in file is null or doesn't exist
     * @throws InvalidCourseException when the inputted course object is not found
     */
    public static ArrayList<Integer> readCourses(String filename, Course course)
        throws FileNotFoundException, InvalidCourseException {
        int lineNum = 0;
        boolean found = false;
        ArrayList<Integer> list = new ArrayList<>();
        File newFile = new File("./" + filename);
        Scanner scanner = new Scanner(newFile);
        if (!newFile.exists() || newFile == null) {
            throw new FileNotFoundException();
        } else {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                lineNum++;
                if (input.contains(course.toString())) {
                    list.add(lineNum);
                    found = true;
                }
            }
            scanner.close();
            if (!found) {
                throw new InvalidCourseException();
            }
        }
        return list;
    }

    /**
     * This is the main method used to test methods.
     *
     * @param args supplies command-line arguments as an array of String objects
     */
    public static void main(String[] args) {
        ComputerScience java = new ComputerScience("Java101", 10001, "Landry", "Java");
        ComputerScience python = new ComputerScience("Python101", 10002, "OO", "Python");
        ComputerScience html = new ComputerScience("HTML101", 10003, "Jack", "HTML");
        LabScience physics = new LabScience("Physics101", 20001, "Adam", true);
        LabScience environment = new LabScience("Environment101", 20002, "Jessica", false);
        LabScience biology = new LabScience("Biology101", 20003, "Mr. Bio", true);

        ArrayList<Course> arraylist = new ArrayList<>();
        arraylist.add(java);
        arraylist.add(python);
        arraylist.add(html);
        arraylist.add(physics);
        arraylist.add(environment);
        arraylist.add(biology);

        try {
            writeCourses("TestCourses.csv", arraylist);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Course> arraylist2 = new ArrayList<>();
        ComputerScience css = new ComputerScience("CSS101", 10004, "Prof CSS", "CSS");
        arraylist2.add(css);


        try {
            outputCourses("TestCourses.csv");
            System.out.println(outputCourses("TestCourses.csv"));
        } catch (InvalidCourseException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            readCourses("TestCourses.csv", java);
        } catch (InvalidCourseException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            writeCourses("TestCourses.csv", arraylist2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}