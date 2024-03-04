import iPhone.IPhoneMenu;

public class App {
    public static void main(String[] args) throws Exception 
    {
        //enumTest();
        //testStudentAssesment();
        //testStudentMenu();
        testIPhoneMenu();
    }

    private static void testIPhoneMenu() 
    {
        new IPhoneMenu().runMainMenu();
    }

    private static void testStudentMenu() 
    {       
        new GradingSystem( new Student()).runMainMenu();
    }

    private static void testStudentAssesment() 
    {
        Student student = new Student();
        student.addAssessment("Programming 1", 77, 100);
        student.addAssessment("Programming 2", Grade.C);
        //student.addAssessment("ProGramming 2", Grade.D);        // caanot add again


        Assessment programmingOne = student.getAssessments().get(0);
        //programmingOne.penalise(10);
        programmingOne.penalise(Grade.C);

        for (Assessment assessment : student.getAssessments()) 
        {
            System.out.println(assessment);
        }
    }

    private static void enumTest()
    {
        Sauce creameFraiche = Sauce.CREAM_FRAICHE;
        System.out.println(creameFraiche);
        System.out.println(creameFraiche.getCost());
        System.out.println(creameFraiche);
    }
}
