package p10_package;


public class StudentClass implements Comparable<StudentClass> {

    private final char COMMA = 44;

    public String name;

    public int studentID;

    public char gender;

    public double gpa;


    /**
     * Initialization constructor for data
     * Note: Class does not require a default constructor
     * @param inName
     * @param inStudentID
     * @param inGender
     * @param inGPA
     */
    public StudentClass(String inName,
                        int inStudentID,
                        char inGender,
                        double inGPA)
    {
        this.name = inName;
        this.studentID = inStudentID;
        this.gender = inGender;
        this.gpa = inGPA;
    }

    /**
     * Copy constructor
     * Calls other constructor with copied data
     * @param copied
     */
    public StudentClass(StudentClass copied)
    {
        new StudentClass
                (copied.name,copied.studentID,copied.gender, copied.gpa);
    }

    /**
     * Compares student objects
     * Note: Compares name as class key; returns integer result such that
     * if this name is less than other name, a negative number is returned;
     * if this name is greater than other name, a positive number is returned;
     * if this name is equal to, and the same length as other name,
     * zero is returned
     *
     * .charAt()
     *
     * Stop when you get the difference in 1 letter.
     *
     * Compare last names, watch for the comma
     * @param other
     * @return
     */
    public int compareTo(StudentClass other)
    {
        int nameIndex = 0;

        while(this.name.charAt(nameIndex) != COMMA)
        {
            if(this.name.charAt(nameIndex) - other.name.charAt(nameIndex) != 0)
            {
                return this.name.charAt(nameIndex)
                        - other.name.charAt(nameIndex);
            }
            nameIndex++;
        }
        return 0;
    }

    /**
     * Creates hash value from local data
     * Algorithm: Accesses the integer values of the characters in
     * the name string up to but not including the first comma;
     * then returns the sum
     *
     * Uses .charAt & .length
     *
     * @return
     */
    public int hashCode()
    {
        int nameIndex = 0;
        int returnValue = 0;
        while(this.name.charAt(nameIndex) != COMMA)
        {
            returnValue = returnValue + this.name.charAt(nameIndex);
            nameIndex++;
        }
        return returnValue;
    }


    /**
     * Overrides Object toString with local
     * @return
     */
    public String toString()
    {
       return this.name + "; " + this.studentID + "; "
               + this.gender + "; " + this.gpa + ";";
    }
}
