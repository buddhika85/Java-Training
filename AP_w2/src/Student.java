/**
 * class Student
 */
public class Student
{
    private int id;
    private String name;
    private double gpa;
    /**
     * Constructor for objects of class Student
     */
    public Student(int id, String name)
    {//set the attribute values
        this.id=id;
        this.name=name;   
        gpa = 0.0;
    }
    /**
     * getId - returns the student id
     */
    public int getId()
    {
        return id;
    }
    /**
     * getName - returns the student name
     */
    public String getName()
    {
        return name;
    }
    /**
     * getGpa - returns the student gpa
     */
    public double getGpa()
    {
        return gpa;
    }
    /**
     * setGpa - set the value of the student gpa attribute
     */
    public void setGpa(double newGpa)
    {
        gpa = newGpa;
    }
}
