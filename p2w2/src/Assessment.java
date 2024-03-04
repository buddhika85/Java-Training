public class Assessment 
{
    private String name;
    private int mark;
    private int totalPossibleMarks;

    //  positive or negative change to the mark that is applied at the discretion of the College. 
    private int fudgeMark;      // 60 fudge -5 -> 55  or 80 and fudge 5 -> 85

    private static final int MAX_HD_MARK = 100;
    private static final int MAX_D_MARK = 84;
    private static final int MAX_C_MARK = 74;
    private static final int MAX_P_MARK = 64;
    private static final int MAX_F_MARK = 49;



    public Assessment(String name, int mark, int totalPossibleMarks, int fudgeMark) {
        this.name = name;
        this.mark = mark;
        this.totalPossibleMarks = totalPossibleMarks;
        this.fudgeMark = fudgeMark;
    }

    public Grade computeGrade()
    {
        int markAfterFudging = getMarkAfterFudging();
        if (markAfterFudging > MAX_D_MARK)
            return Grade.HD;
        else if (markAfterFudging > MAX_C_MARK)
            return Grade.D;
        else if (markAfterFudging > MAX_P_MARK)
            return Grade.C;
        else if (markAfterFudging > MAX_F_MARK)
            return Grade.P;
        else
            return Grade.F;   
    }

    private int getMarkAfterFudging() 
    {
        return mark + fudgeMark;
    }

    // e.g. calling penalise(10) means a 10-mark penalty is applied, which means fudgeMark is set to -10.
    public void penalise(int penalty)
    {
        if (penalty < 0)
        {
            System.out.println("Error = Invalid Panelty. Must be positive");
            return;
        }
        fudgeMark = -penalty;
    }

    // which sets fudgeMark to the largest possible value such that the resulting grade of the assessment is equal to newGrade. 
    // For example, suppose an assessment's mark is 77 out of 100, for a grade of D. Calling penalise(Grade.CREDIT) 
    // should result in a fudgeMark of -3 (as it results in a mark of 74, which is the largest possible score to obtain a C grade).
    public void penalise(Grade newGrade)
    {
        int possibleMaxMark = 0;
        if (newGrade == Grade.HD)        
            possibleMaxMark = MAX_HD_MARK; 
        else if (newGrade == Grade.D)
            possibleMaxMark = MAX_D_MARK;        
        else if (newGrade == Grade.C)        
            possibleMaxMark = MAX_C_MARK;
        else if (newGrade == Grade.P)
            possibleMaxMark = MAX_P_MARK;
        else 
            possibleMaxMark = MAX_F_MARK;
        

        // if mark 77 and newGrade = C
        // -3 = 74 - 77

        // if mark 71 and newGrade = C
        // 3 = 74 - 71
        fudgeMark = possibleMaxMark - mark;
    }

    @Override
    public String toString() {
        return "Assessment [name=" + name + ", mark=" + mark + ", totalPossibleMarks=" + totalPossibleMarks
                + ", fudgeMark=" + fudgeMark + ", mark after fudging=" + getMarkAfterFudging() + ", final grade =" + computeGrade() + "]";
    }

    
}
