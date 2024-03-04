import iPhone.IPhoneMenu;

public class App {
    public static void main(String[] args) throws Exception 
    {
        //enumTest();
        //testStudentAssesment();
        //testStudentMenu();
        //testIPhoneMenu();
        testPizza();
    }

    private static void testPizza() 
    {
        Pizza pizza = new Pizza(1000, new Topping[] {Topping.CHICKEN});     // 1000
        System.out.println(pizza.calculatePrice());
        pizza.addTopping(Topping.CHEESE);       // 1050
        pizza.addTopping(Topping.BACON);        // 1110
        System.out.println(pizza.calculatePrice());
        //pizza.applyDiscount(110);
        pizza.applyDiscountRate(0.1);
        System.out.println(pizza.calculatePrice());
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
