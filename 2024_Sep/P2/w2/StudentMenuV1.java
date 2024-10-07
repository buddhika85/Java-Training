public class StudentMenuV1 
{
    Student student = new Student();

    public static void main(String[] args) 
    {
        new StudentMenuV1().runMainMenu();    
    }

    void runMainMenu() 
    {
        System.out.println("--- Student Main menu ---");
        while (true) 
        {
            System.out.println("\nSelect an option:");
            System.out.println("  1. Add assessment");
            System.out.println("  2. View assessments");
            System.out.println("  3. Update an assessment mark");
            System.out.println("  4. Update an assessment grade");
            System.out.println("  5. Exit");
            int choice = In.nextInt();
            if (choice == 1) 
            {
                addAssessment();
            }             
            else if (choice == 2) 
            {
                viewAssessments();
            } 
            else if (choice == 3) 
            {
                updateAnAssessment();
            }
            else if (choice == 4) 
            {
                updateAnAssessmentByGrade();
            }  
            else if (choice == 5) 
            {
                break;
            }             
            else 
            {
                System.out.println("Pick an option 1, 2,3, 4 or 5");
            }
        }

        System.out.println("Exiting...");
    }

    private void updateAnAssessmentByGrade() 
    {
        System.out.println("To Do");
    }

    private void addAssessment() 
    {
        System.out.println("\n-- Add Assessment --");

        String name = readStringAnswer("name of assessment");
        int mark = readMark();

        student.addAssessment(name, mark, 100);
    }

    private int readMark() 
    {
        while(true)
        {
            System.out.print("\t mark : ");
            int mark = In.nextInt();    
            if (mark >= 0 && mark <= 100)
            {
                return mark;
            }
        }        
    }

    private String readStringAnswer(String question)
    {
        System.out.print("\t " + question + " : ");
        return In.nextLine();
    }

    private void viewAssessments() 
    {
        System.out.println("\n-- View All Assessments --");
        if (student.assessments.size() == 0)
        {
            System.out.println("\tNo assessments");
            return;
        }


        for (Assessment assessment : student.assessments) 
        {
            System.out.println(assessment);
        }
    }
    
    private void updateAnAssessment() 
    {
        System.out.println("\n-- Update Assessment --");

        String name = readStringAnswer("name of assessment");
        if (!student.isExists(name))
        {
            System.out.println("Error - unable to update, no assessment with such name");
            return;
        }

        int mark = readMark();
        student.updateAssessment(name, mark);
    }
}
