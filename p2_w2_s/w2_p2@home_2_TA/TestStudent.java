public class TestStudent 
{
    public static void main(String[] args) 
    {
        Student student = new Student();
        student.addAssessment("A1", Grade.C);
        student.addAssessment("A2", 77, 100);
        student.addAssessment("A3", 60, 100);
        
        // display all
        for (Assessment assessment : student.assessments) {
            System.out.println(assessment);
        }

        System.out.println("\nAfter applying fudge marks");
        student.assessments.get(0).penalise(10);;
        student.assessments.get(1).penalise(Grade.D);
        student.assessments.get(2).penalise(Grade.D);
        for (Assessment assessment : student.assessments) {
            System.out.println(assessment);
        }
    }    
}
