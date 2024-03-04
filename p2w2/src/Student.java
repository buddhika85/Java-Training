import java.util.ArrayList;

public class Student 
{
    private ArrayList<Assessment> assessments = new ArrayList<>();

    public ArrayList<Assessment> getAssessments() 
    {
        return assessments;
    }

    public void addAssessment(String name, int mark, int totalPossibleMarks)
    {
        if (isExistingAssessment(name))
        {
            System.out.println("Error: assessment with " + name + " already exists.");
            return;
        }

        assessments.add(new Assessment(name, mark, totalPossibleMarks, 0));
        System.out.println("Added assessment");
    }

    public void addAssessment(String name, Grade grade)
    {
        if (isExistingAssessment(name))
        {
            System.out.println("Error: assessment with " + name + " already exists.");
            return;
        }

        assessments.add(new Assessment(name, grade));
        System.out.println("Added assessment");
    }

    private boolean isExistingAssessment(String name) 
    {
        for (Assessment assessment : assessments) 
        {
            if (assessment.getName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    public Assessment getAssessment(String name) 
    {
        for (Assessment assessment : assessments) 
        {
            if (assessment.getName().equalsIgnoreCase(name))
                return assessment;
        }
        return null;
    }
}
