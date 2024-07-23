import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UTSCollegeIT {
    public static void main(String[] args) {

        Student[] studentDataArray = {
                new Student("Thomas Munster", 34534, "accelerated", 21,
                        new ArrayList<>(Arrays.asList("IIIS001", "IPRO002", "INET001", "IDBF001"))),
                new Student("John Smith", 1111, "standard", 19,
                        new ArrayList<>(Arrays.asList("IWBS001", "IBRM001", "IPRO002"))),
                new Student("Sarah Johnson", 2222, "accelerated", 18,
                        new ArrayList<>(Arrays.asList("IBRM001", "IPRO002", "INET001", "IDBF001"))),
                new Student("Emily Davis", 3333, "extended", 20,
                        new ArrayList<>(Arrays.asList("IWBS001", "IIIS001", "IPRO002"))),
                new Student("Michael Thompson", 4444, "standard", 17,
                        new ArrayList<>(Arrays.asList("IWBS001", "IBRM001", "IPRO001"))),
                new Student("Jessica Brown", 5555, "accelerated", 21,
                        new ArrayList<>(Arrays.asList("IBRM001", "IPRO002", "INET001", "IDBF001"))),
                new Student("Daniel Wilson", 6666, "extended", 19,
                        new ArrayList<>(Arrays.asList("IWBS001", "IBRM001", "IPRO001"))),
                new Student("Olivia Miller", 7777, "standard", 18,
                        new ArrayList<>(Arrays.asList("IWBS001", "IIIS001", "IPRO002")))
        };

        // 1
        
    }
}

class Student {
    String name;
    int studentNumber;
    String variation;
    int age;
    ArrayList<String> enrolledSubjects;

    public Student(String name, int studentNumber, String variation, int age, ArrayList<String> enrolledSubjects) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.variation = variation;
        this.age = age;
        this.enrolledSubjects = enrolledSubjects;
    }
}
