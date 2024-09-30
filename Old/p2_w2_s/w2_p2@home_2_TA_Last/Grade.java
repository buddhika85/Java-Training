enum Grade
{
    HD(85, 100),                 // 85 to 100 inclusive
    D(75, 84),                  // 75 to 84
    C(65, 74),                  // 65 to 74
    P(50, 64),                  // 50 to 64
    F(0, 49);                   // 0 to 49

    private int minMark;   
    private int maxMark;
   

    private Grade(int minMark, int maxMark)
    {
        this.minMark = minMark;
        this.maxMark = maxMark;
    }

    public int getMaxMark() {
        return maxMark;
    }

    public int getMinMark() {
        return minMark;
    }

    @Override
    public String toString()
    {
        return this.name() + " - " + minMark + " to " +  maxMark;
    }
}