public class TestStudent 
{
    public static void main(String[] args) 
    {
        Student student = new Student();
        student.addAssessment("A1", Grade.C, Unit.PROGRAMMING_1);
        student.addAssessment("A2", 77, 100, Unit.PROGRAMMING_1);
        student.addAssessment("A3", 60, 100, Unit.PROGRAMMING_1);
        
        // display all
        for (Assessment assessment : student.assessmentsProgramming1) {
            System.out.println(assessment);
        }

        System.out.println("\nAfter applying fudge marks");
        student.assessmentsProgramming1.get(0).penalise(10);;
        student.assessmentsProgramming1.get(1).penalise(Grade.D);
        student.assessmentsProgramming1.get(2).penalise(Grade.D);
        for (Assessment assessment : student.assessmentsProgramming1) {
            System.out.println(assessment);
        }
    }    
}
