import java.util.ArrayList;

class Assessment
{
    String name;
    int mark;
    int totalPossibleMarks;

    // positive or negative change to the mark that is applied at the discretion of the College.
    // For example, if a student obtained a mark of 60, and a fudge mark of -5 was applied, the final mark becomes 60 - 5 == 55.
    int fudgeMark;

    public Assessment(String name, int mark, int totalPossibleMarks) 
    {
        this.name = name;
        this.mark = mark;
        this.totalPossibleMarks = totalPossibleMarks;
        this.fudgeMark = 0;
    }

    public Grade computeGrade()
    {
        int mark = this.mark + fudgeMark;
        if (mark >= 85 && mark < 100)
        {
            return Grade.HD;
        }
        else if (mark >= 75)
        {
            return Grade.D;
        }
        else if (mark >= 65)
        {
            return Grade.C;
        }
        else if (mark >= 50)
        {
            return Grade.P;
        }
        else
        {
            return Grade.F;
        }
    }

    /*
    which applies a penalty to the assessment's mark by setting the fudgeMark. 
    Note: the penalty parameter must be positive. e.g. calling penalise(10) means 
    a 10-mark penalty is applied, which means fudgeMark is set to -10.
     */
    public void penalise(int penalty)
    {
        fudgeMark = penalty * -1;
    }

    // sets fudgeMark to the largest possible value such that the resulting newGrade. 
    // For example, suppose an assessment's mark is 77 out of 100, for a grade of D. 
    // Calling penalise(Grade.CREDIT) should result in a fudgeMark of -3 
    // (as it results in a mark of 74, which is the largest possible score to obtain a C grade).
    // mark  + fudgeMark  = Grade Largest possible value
    // 77 + -3 = 74
    // fudgeMark = Grade largest - mark
    // -3 = 74 - 77    

    // mark = 51
    // Calling penalise(Grade.CREDIT) = 
    // fudge = 74 - 51 => 23
    // Add 23 to 51, students gets highest possible credit
    public void penalise(Grade newGrade)
    {
        fudgeMark = newGrade.getMaximum() - mark;
    }

    @Override
    public String toString() {
        return "Assessment name=" + name + ", mark=" + mark + ", totalPossibleMarks=" + totalPossibleMarks
                + ", fudgeMark=" + fudgeMark + ", FINAL = " + (mark + fudgeMark) + ", GRADE = " + computeGrade().name();
    }
}

class Student
{
    ArrayList<Assessment> assessments =  new ArrayList<>();

    public void addAssessment(String name, int mark, int totalPossibleMarks)
    {
        if (isExists(name))
        {
            System.out.println("Error - assessment with same name already exists, so cannot add again");
            return;
        }

        assessments.add(new Assessment(name, mark, totalPossibleMarks));
        System.out.println("Assessment added");
    }

    public boolean isExists(String name) 
    {
        for (Assessment assessment : assessments) 
        {
            if (assessment.name.equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public Assessment findAssessment(String name)
    {
        for (Assessment assessment : assessments) 
        {
            if (assessment.name.equals(name))
            {
                return assessment;
            }
        }
        return null;
    }

    public void updateAssessment(String name, int mark) 
    {
        Assessment assessment = findAssessment(name);
        if (assessment == null)
        {
            System.out.println("Error - unable to update, no assessment with such name");
            return;
        }

        assessment.mark = mark;
        assessment.fudgeMark = 0;       // assumption: fudge mark resets
        System.out.println("Assessment updated");
    }
}