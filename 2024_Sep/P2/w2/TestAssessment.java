public class TestAssessment 
{
    public static void main(String[] args) 
    {
       
        Assessment assessmentA1 = new Assessment("A1", 77, 100);
        Assessment assessmentA2 = new Assessment("A2", 51, 100);

        assessmentA1.penalise(Grade.C);
        assessmentA2.penalise(Grade.C);

        System.out.println(assessmentA1);
        System.out.println(assessmentA2);

        Student student = new Student();
        student.addAssessment("P1 a1", 90, 100);
        student.addAssessment("P1 a2", 85, 100);
        student.addAssessment("P1 a1", 90, 100);

        System.out.println("\nAll student assessments\n");
        for (Assessment assessment : student.assessments) 
        {
            System.out.println(assessment);    
        }
    }
}
