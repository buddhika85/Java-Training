public class Assessment 
{
    private String name;
    private int mark;
    private final int TOTAL_POSSIBLE_MARK;

    // positive or negative change to the mark that is applied at the discretion of the College. 
    // if a student obtained a mark of 60, 
    // and a fudge mark of -5 was applied, the final mark becomes 60 - 5 == 55
    private int fudgeMark;

    public Assessment(String name, int mark, int totalPossibleMarks, int fudgeMark) {
        this.name = name;
        this.mark = mark;
        TOTAL_POSSIBLE_MARK = totalPossibleMarks;
        this.fudgeMark = fudgeMark;
    }

    // HD,                 // 85 to 100 inclusive
    // D,                  // 75 to 84
    // C,                  // 65 to 74
    // P,                  // 50 to 64
    // F                   // 0 to 49
    public Grade computeGrade()
    {
        int mark = getFinalMark();
        if (mark >= 85)
        {
            return Grade.HD;
        }
        else if (mark >= 75 && mark <= 84)
        {
            return Grade.D;
        }
        else if (mark >= 65 && mark <= 74)
        {
            return Grade.C;
        }
        else if (mark >= 50 && mark <= 64)
        {
            return Grade.P;
        }
        else
        {
            return Grade.F;
        }

        // another way
        // if (mark >= Grade.HD.getMinMark())
        // {
        //     return Grade.HD;
        // }
        // else if (mark >= Grade.D.getMinMark() && mark <= Grade.D.getMaxMark())
        // {
        //     return Grade.D;
        // }
        // else if (mark >= Grade.C.getMinMark() && mark <= Grade.C.getMaxMark())
        // {
        //     return Grade.C;
        // }
        // else if ((mark >= Grade.P.getMinMark() && mark <= Grade.P.getMaxMark()))
        // {
        //     return Grade.P;
        // }
        // else
        // {
        //     return Grade.F;
        // }

        // better way using a loop
        // for (Grade grade : Grade.values()) {
        //     if ((mark >= grade.getMinMark() && mark <= grade.getMaxMark()))
        //     {
        //         return grade;
        //     }
        // }
    }
    
    public void penalise(int penalty)
    {
        // Note: the penalty parameter must be positive. 
        // e.g. calling penalise(10) means a 10-mark penalty is applied, which means fudgeMark is set to -10.
        fudgeMark = penalty * -1;
    }
    
    // sets fudgeMark to the largest possible value such that the resulting grade of the assessment is equal to newGrade
    //  example, an assessment's mark is 77 out of 100, for a grade of D. 
    // example 1: Calling penalise(Grade.CREDIT) 
    // should result in a fudgeMark of -3 (as it results in a mark of 74, 
    // fudgeMark = largestPossibleMark - mark;
    // = 74 - 77 => -3
    // example 2: Calling penalise(Grade.D) , original mark is 60
    // fudgeMark = largestPossibleMark - mark;
    // = 84 - 60 => 24
    public void penalise(Grade newGrade)
    {        
        fudgeMark = newGrade.getMaxMark() - mark;
    }

    // calculates final mark after applying fudge mark
    public int getFinalMark()
    {
        return mark + fudgeMark;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", original mark = " + mark + ", fudge mark = " + fudgeMark 
            + ", final mark = " + getFinalMark() + " / " + TOTAL_POSSIBLE_MARK 
            + " , final grade = " + computeGrade().name();
    }
}
