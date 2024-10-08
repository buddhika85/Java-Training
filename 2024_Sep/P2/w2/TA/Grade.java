enum Grade 
{
    HD(100, 85), D(84, 75), C(74, 65), P(64, 50), F(49, 0);

    private int max;
    private int min;

    private Grade(int max, int min) 
    {
        this.max = max;
        this.min = min;
    }

    public int getMaximum() 
    {
        return this.max;
    }    

    public int geMinimum()
    {
        return this.min;
    }

    @Override
    public String toString()
    {
        return this.name() + " min " + min + " to max " + max;
    }
}

class Test
{
    public static void main(String[] args) 
    {
        
        for (Grade grade : Grade.values()) 
        {
            System.out.println(grade);
        }
    }
}
