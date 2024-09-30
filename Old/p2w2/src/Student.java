import java.util.ArrayList;

public class Student 
{
    private ArrayList<Assessment> assessmentProg1 = new ArrayList<>();
    private ArrayList<Assessment> assessmentProg2 = new ArrayList<>();

    private ArrayList<Assessment> assessmentsToUse = assessmentProg1;

    

    public void setAssessmentsToUse(int num) 
    {
        if (num == 2)
        {
            assessmentsToUse = assessmentProg2;
            System.out.println("Unit: Programming 2");
        }
        else
        {
            assessmentsToUse = assessmentProg1;
            System.out.println("Unit: Programming 1");
        }
    }

    public ArrayList<Assessment> getAssessments() 
    {
        return assessmentsToUse;
    }

    public void addAssessment(String name, int mark, int totalPossibleMarks)
    {
        if (isExistingAssessment(name))
        {
            System.out.println("Error: assessment with " + name + " already exists.");
            return;
        }

        assessmentsToUse.add(new Assessment(name, mark, totalPossibleMarks, 0));
        System.out.println("Added assessment");
    }

    public void addAssessment(String name, Grade grade)
    {
        if (isExistingAssessment(name))
        {
            System.out.println("Error: assessment with " + name + " already exists.");
            return;
        }

        assessmentsToUse.add(new Assessment(name, grade));
        System.out.println("Added assessment");
    }

    private boolean isExistingAssessment(String name) 
    {
        for (Assessment assessment : assessmentsToUse) 
        {
            if (assessment.getName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    public Assessment getAssessment(String name) 
    {
        for (Assessment assessment : assessmentsToUse) 
        {
            if (assessment.getName().equalsIgnoreCase(name))
                return assessment;
        }
        return null;
    }
}
