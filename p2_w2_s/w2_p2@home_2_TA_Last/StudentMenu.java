public class StudentMenu {

    private Student student = new Student();
    private Unit selectedUnit = Unit.PROGRAMMING_1;

    public static void main(String[] args) {
        
        StudentMenu studentMenu = new StudentMenu();
        studentMenu.addTestData();
        studentMenu.runMainMenu();
    }

    private void addTestData() 
    {
        student.addAssessment("A1", Grade.C, Unit.PROGRAMMING_1);
        student.addAssessment("A2", 77, 100, Unit.PROGRAMMING_1);
        student.addAssessment("A3", 60, 100, Unit.PROGRAMMING_1);
    }

    void runMainMenu() 
    {
        System.out.println("--- Main menu ---");
        while (true) {
            System.out.println("Select an option for " + selectedUnit.name() + ":");
            System.out.println("  1. Add Assessment");
            System.out.println("  2. View Assessments");
            System.out.println("  3. Modify grade of an assessment");
            System.out.println("  4. Change selected unit");
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
                modifyGrade();
            } 
            else if (choice == 4) 
            {
                selectUnit();
            } 
            else if (choice == 5) 
            {
                break;
            } 
            else 
            {
                System.out.println("Pick an option 1, 2, 3 or 4");
            }
        }

        System.out.println("Exiting...");
    }

    private void selectUnit() {
        System.out.println("\nSelect unit number, 1 for Programming 1 or 2 for Programming 2:");
        int input = In.nextInt();
        if (input == 1)
            selectedUnit = Unit.PROGRAMMING_1;
        else
            selectedUnit = Unit.PROGRAMMING_2;
    }

    private void addAssessment() 
    {
        System.out.println("\n--- Add assessment sub menu ---");
        while (true) {
            System.out.println("Select an option:");
            System.out.println("  1. Add assessment by mark");
            System.out.println("  2. Add assessment by grade");
            System.out.println("  3. Back to main menu");
            int choice = In.nextInt();
            if (choice == 1) {
                addAssessmentByMark();
            } else if (choice == 2) {
                addAssessmentByGrade();           
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Pick an option 1, 2 or 4");
            }
        }
        System.out.println("Back to main menu...");
    }

    private void addAssessmentByGrade() 
    {
        System.out.println("\nAdd Assessment By Grade ");
        System.out.println("Please provide assessment name: ");
        String name = In.nextLine();        
        student.addAssessment(name, readGrade(), selectedUnit);
    }

    private Grade readGrade()
    {        
        int gradeNum = 0;
        while(gradeNum <= 0 || gradeNum > 5)
        {
            System.out.println("Please provide 1 for HD, 2 for D, 3 for C, 4 for P, 5 for F: ");
            gradeNum = In.nextInt();
        }

        return findGradeByGradeNum(gradeNum);
    }

    private Grade findGradeByGradeNum(int gradeNum) 
    {
        if (gradeNum == 1)
            return Grade.HD;
        else if (gradeNum == 2)
            return Grade.D;
        else if (gradeNum == 3)
            return Grade.C;
        else if (gradeNum == 4)
            return Grade.P;

        return Grade.F;
    }

    private void addAssessmentByMark() 
    {
        System.out.println("\nAdd Assessment By Mark ");
        System.out.println("Please provide assessment name: ");
        String name = In.nextLine();

        System.out.println("Please provide assessment mark:");
        int mark = In.nextInt();

        // we will assume here that total mark is 100 for simplicity
        student.addAssessment(name, mark, 100, selectedUnit);
    }    

    private void viewAssessments() 
    {
        System.out.println("\nView Student Assessments \nProgramming 1");
        for (Assessment assessment : student.assessmentsProgramming1) {
            System.out.println("\t" + assessment);
        }

        System.out.println("\nProgramming 2");
        for (Assessment assessment : student.assessmentsProgramming2) {
            System.out.println("\t" + assessment);
        }
    }

    private void modifyGrade() 
    {
        System.out.println("\nModify Assessment ");
        System.out.println("Please provide assessment name: ");
        String name = In.nextLine();
        Assessment assessment = student.getAssessmentByName(name, selectedUnit);
        if (assessment == null)
        {
            System.out.println("Error: assessment not found");
            // cannot proceed, go back to caller
            return;
        }

        assessment.penalise(readGrade());
        System.out.println("Success: Assessment grade modified.");
    }
}
