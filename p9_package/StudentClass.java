package p9_package;

public class StudentClass implements Comparable<StudentClass> {
    public String name;

    public int studentID;

    public char gender;

    public double gpa;

    /**
     * Initialization constructor for data
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
        new StudentClass(copied.name,copied.studentID,copied.gender,copied.gpa);
    }

    /**
     * Compares student objects
     * Note: Compares gpa as class key; returns integer result such that
     * if this gpa is less than other gpa, a negative number is returned;
     * if this gpa is greater than other gpa, a positive number is returned;
     * if this gpa is equal to other gpa, zero is returned
     *
     * Note: difference precision is 0.00001
     *
     * @param other
     * @return
     */
    public int compareTo(StudentClass other)
    {
        if(this.gpa - other.gpa > 0)
        {
            return 1;
        }
        if(this.gpa - other.gpa < 0)
        {
            return -1;
        }

        return 0;
    }

    /**
     * Overrides Object toString with local
     * @return
     */
    public String toString()
    {
        return this.name + '/' + this.studentID + '/' + this.gender + '/' + this.gpa;
    }
}
