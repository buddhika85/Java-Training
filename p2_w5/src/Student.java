import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Student 
{
    double averageMark;
    String firstName, lastName;

    static final Comparator<Student> comparatorLastNameThenFirstName = Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName);
    static final Comparator<Student> comparatorLastNameReverse = Comparator.comparing(Student::getLastName).reversed();


    // modify the comparator above to first sort by averageMark in descending order (largest-to-smallest)
    static final Comparator<Student> comparatorAvgReverse = Comparator.comparing(Student::getAverageMark).reversed();


    // modify the comparator above to first sort by averageMark in descending order (largest-to-smallest). Then sort like usual with lastName then firstName.
    static final Comparator<Student> comparatorAvgReverseAndNames = 
        Comparator.comparing(Student::getAverageMark).reversed().thenComparing(Student::getLastName).thenComparing(Student::getFirstName);

    Student(String firstName, String lastName, double averageMark) 
    {
        this.averageMark = averageMark;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public double getAverageMark() 
    {
        return averageMark;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    @Override
    public String toString() 
    {
        return this.lastName + ", " + this.firstName + ", average mark: " + this.averageMark;
    }

    public static void main(String[] args) 
    {
        Student s0 = new Student("Taylor", "Swift", 67);
        Student s1 = new Student("Conor", "McGregor", 90);
        Student s2 = new Student("Timothy", "Ling", 71.1);
        Student s3 = new Student("David", "Ling", 91.1);

        Student[] array = { s0, s1, s2, s3 };
        ArrayList<Student> arrayList = new ArrayList<>(Arrays.asList(array));

        System.out.println("Original");
        display(arrayList);

        System.out.println("\nSort by last name and then sort by first name");
        Collections.sort(arrayList, Student.comparatorLastNameThenFirstName);
        display(arrayList);

        System.out.println("\nSort by last name reversed");
        Collections.sort(arrayList, Student.comparatorLastNameReverse);
        display(arrayList);

        System.out.println("\nSort by average reversed");
        Collections.sort(arrayList, Student.comparatorAvgReverse);
        display(arrayList);

        System.out.println("\nSort by average reversed and names");
        Collections.sort(arrayList, Student.comparatorAvgReverseAndNames);
        display(arrayList);
    }

    private static void display(ArrayList<Student> arrayList) 
    {
        for (Student student : arrayList) 
        {
            System.out.println("\t" + student);
        }
    }
}
