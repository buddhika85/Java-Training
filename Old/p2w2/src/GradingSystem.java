import iPhone.In;

public class GradingSystem 
{

    private Student student;
    

    public GradingSystem(Student student) 
    {
        this.student = student;
    }


    public void runMainMenu() 
    {
        System.out.println("--- Student grading system ---");
        while (true) 
        {
            System.out.println("Select an option:");
            System.out.println("  1. Add Assessment");
            System.out.println("  2. View Assements");
            System.out.println("  3. Modify Grade");
            System.out.println("  4. Set Subject");
            System.out.println("  5. Exit");
            int choice = In.nextInt();
            if (choice == 1) 
            {
                addAssessmentSubMenu();
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
                setSubject();
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


    private void setSubject() 
    {
        System.out.println("Select Subject\n[1] For Programming 1\n[2] For Programming 2");
        student.setAssessmentsToUse(In.nextInt());
    }


    private void viewAssessments() 
    {        
        for (Assessment assessment : student.getAssessments()) 
        {
            System.out.println(assessment);
        }
    }


    private void addAssessmentSubMenu() 
    {        
        System.out.println("--- Sub-menu Adding Assessment ---");
        while (true) {
            System.out.println("Select an option:");
            System.out.println("  1. Add by mark");
            System.out.println("  2. Add by grade");
            System.out.println("  3. Back to main menu");
            int choice = In.nextInt();
            if (choice == 1) {
                addAssementByMark();
            } else if (choice == 2) {
                addAssementByGrade();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Pick an option 1, 2 or 3");
            }
        }
        System.out.println("Back to main menu...");
    }


    private void addAssementByMark() 
    {
       System.out.println("------ Add assessment by mark ------");
       System.out.println("Assessment name: ");
       String assessmentName = In.nextLine();
       System.out.println("Assessment mark: ");
       int mark = In.nextInt();
       student.addAssessment(assessmentName, mark, 100);       
    }


    private void addAssementByGrade() 
    {
        System.out.println("------ Add assessment by grade ------");
        System.out.println("Assessment name: ");
        String assessmentName = In.nextLine();
        System.out.println("Assessment grade [0-HD, 1-D, 2-C, 3-P, 4-F]: ");
        Grade grade = getGrade(In.nextInt());
        student.addAssessment(assessmentName, grade);
    }


    private Grade getGrade(int gradeIndex) 
    {
        switch (gradeIndex)
        {
            case 0:return Grade.HD;
            case 1:return Grade.D;
            case 2:return Grade.C;
            case 3:return Grade.P;
            default:return Grade.F;
        }
    }


    private void modifyGrade()
    {       
        System.out.println("------ Modify grade ------");
        System.out.println("Assessment name: ");
        Assessment assessment = student.getAssessment(In.nextLine());
        if(assessment == null)
        {
            System.out.println("Error: assessment with such name does not exist");
        }
        else
        {
            // modify
            modifyGradeSubMenu(assessment);
        }
    }


    private void modifyGradeSubMenu(Assessment assessment) 
    {
        System.out.println("--- Sub-menu Adding Assessment ---");
        while (true) {
            System.out.println("Select an option:");
            System.out.println("  1. Apply penalty");
            System.out.println("  2. Apply a max grade");
            System.out.println("  3. Back to main menu");
            int choice = In.nextInt();
            if (choice == 1)
            {
                System.out.println("Panalty mark: ");
                assessment.penalise(In.nextInt());
                System.out.println("Modified grade for assessment - " + assessment);                
            } 
            else if (choice == 2)
            {
                System.out.println("Assessment grade [0-HD, 1-D, 2-C, 3-P, 4-F]: ");
                Grade grade = getGrade(In.nextInt());
                assessment.penalise(grade);
                System.out.println("Modified grade for assessment - " + assessment);                
            } 
            else 
            {
                break;
            }
        }
        System.out.println("Back to main menu...");
    }
}
