import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        ArrayList<Student> studentData = new ArrayList<>(Arrays.asList(studentDataArray));
        HashMap<String, Integer> variationCounts = new HashMap<>();
        for (Student s : studentData) {
                Integer courseCount = variationCounts.get(s.variation);
                if (courseCount == null) {
                    // If courseCount is null, the key (with value `s.variation`)
                    // doesn't currently exist in the map. This means that `s` is 
                    // the first student studying this variation, and so the
                    // current count for it is 1.
                    variationCounts.put(s.variation, 1);
                } else {
                    // What's the new count equal to?
                    variationCounts.put(s.variation, ++courseCount);
                }
        }
        for (Map.Entry<String, Integer> entry : variationCounts.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        HashMap<Integer, Integer> ageCounts = new HashMap<>();
        for (Student s : studentData) {
                Integer ageCount = ageCounts.get(s.age);
                if (ageCount == null) {                    
                        ageCounts.put(s.age, 1);
                } else {
                        // What's the new count equal to?
                        ageCounts.put(s.age, ++ageCount);
                }
        }
        for (Map.Entry<String, Integer> entry : variationCounts.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : ageCounts.entrySet()) {
                System.out.println(entry.getKey() + " age -> " + entry.getValue());
        }


        System.out.println("\n\nNext subject counts \n\n");
        HashMap<String, Integer> subjectCounts = new HashMap<>();
        for (Student student : studentData) {
                for (String subjectCode : student.enrolledSubjects) 
                {
                        Integer count = subjectCounts.get(subjectCode);
                        if (count == null)
                        {
                                subjectCounts.put(subjectCode, 1);
                        }
                        else
                        {
                                subjectCounts.put(subjectCode, ++count);
                        }
                }
        }
        for (Map.Entry<String, Integer> entry : subjectCounts.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
         // 4
        HashMap<String, String> codeAndNames = new HashMap<>();
        codeAndNames.put("IDBF001", "Database fundamentals");
        codeAndNames.put("IBRM001", "Business Requirements Modelling");
        codeAndNames.put("IIIS001", "Introduction to Information Systems");
        codeAndNames.put("IWBS001", "Web Systems");
        codeAndNames.put("INET001", "Network Fundamentals");
        codeAndNames.put("IPRO001", "Programming 1");
        codeAndNames.put("IPRO002", "Programming 2");
        System.out.println(codeAndNames);
        for (Map.Entry<String, Integer> entry : subjectCounts.entrySet()) {
                System.out.println(codeAndNames.get(entry.getKey()) + ": " + entry.getValue() + " students enrolled");
        }
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