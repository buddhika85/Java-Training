import java.util.ArrayList;
import java.util.Arrays;

public class UTSCollegeIT 
{
    public static void main(String[] args) 
    {
        
    }
}

class Student 
{
    String name;
    int studentNumber;
    String course;
    int age;
    ArrayList<String> enrolledSubjects;

    public Student(String name, int studentNumber, String course, int age, ArrayList<String> enrolledSubjects) 
    {
        this.name = name;
        this.studentNumber = studentNumber;
        this.course = course;
        this.age = age;
        this.enrolledSubjects = enrolledSubjects;
    }
}

class ITStudentData 
{
    public static Student[] studentData = 
    {
            new Student("Thomas Munster", 34534, "accelerated", 21,
                    new ArrayList<>(Arrays.asList("IIIS001", "IAPP001", "INET001", "IDBF001"))),
            new Student("John Smith", 1111, "standard", 19,
                    new ArrayList<>(Arrays.asList("IWBS001", "IBRM001", "IAPP001"))),
            new Student("Sarah Johnson", 2222, "accelerated", 18,
                    new ArrayList<>(Arrays.asList("IBRM001", "IAPP001", "INET001", "IDBF001"))),
            new Student("Emily Davis", 3333, "extended", 20,
                    new ArrayList<>(Arrays.asList("IWBS001", "IIIS001", "IAPP001"))),
            new Student("Michael Thompson", 4444, "standard", 17,
                    new ArrayList<>(Arrays.asList("IWBS001", "IBRM001", "IPRG001"))),
            new Student("Jessica Brown", 5555, "accelerated", 21,
                    new ArrayList<>(Arrays.asList("IBRM001", "IAPP001", "INET001", "IDBF001"))),
            new Student("Daniel Wilson", 6666, "extended", 19,
                    new ArrayList<>(Arrays.asList("IWBS001", "IBRM001", "IPRG001"))),
            new Student("Olivia Miller", 7777, "standard", 18,
                    new ArrayList<>(Arrays.asList("IWBS001", "IIIS001", "IAPP001")))
    };
}