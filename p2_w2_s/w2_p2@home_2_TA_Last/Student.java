import java.util.ArrayList;

public class Student 
{
    // for simplicity I made this non private
    // not recomended for projects, assignments, exams..etc, unless it is stated in the question
    ArrayList<Assessment> assessmentsProgramming1 = new ArrayList<>();
    ArrayList<Assessment> assessmentsProgramming2 = new ArrayList<>();

    public void addAssessment(String name, int mark, int totalPossibleMarks, Unit unit)
    {
        if (getAssessmentByName(name, unit) != null)
        {
            System.out.println("Error - assessment with same name already exists.");
            return;
        }

        // add
        if (unit == Unit.PROGRAMMING_1)
            assessmentsProgramming1.add(new Assessment(name, mark, totalPossibleMarks, 0));
        else
            assessmentsProgramming2.add(new Assessment(name, mark, totalPossibleMarks, 0));
        System.out.println("Success - Assessment added.");
    }

    // assumptions - 
    // total possible mark is always 100
    // we give highest possible mark for the grade here
    public void addAssessment(String name, Grade grade, Unit unit)
    {
        if (getAssessmentByName(name, unit) != null)
        {
            System.out.println("Error - assessment with same name already exists.");
            return;
        }

         // add
         if (unit == Unit.PROGRAMMING_1)
            assessmentsProgramming1.add(new Assessment(name, grade.getMaxMark(), 100, 0));
         else
            assessmentsProgramming2.add(new Assessment(name, grade.getMaxMark(), 100, 0));
         System.out.println("Success - Assessment added.");
    }

    public Assessment getAssessmentByName(String name, Unit unit) 
    {
        ArrayList<Assessment> assessments = assessmentsProgramming1;
        if (unit == Unit.PROGRAMMING_2)
            assessments = assessmentsProgramming2;

        for (Assessment assessment : assessments) 
        {
            if (assessment.getName().equals(name))
            {
                return assessment;
            }
        }
        return null;
    }
}
