public class Q8 
{
    public static void main(String[] args) 
    {
        PoliceMan detective = new PoliceMan("Jack", PoliceManType.DETECTIVES);
        PoliceMan officer = new PoliceMan("Gill", PoliceManType.OFFICERS);

        System.out.println(detective.calculateMonthlyIncome());
        System.out.println(officer.calculateMonthlyIncome());
    }
    
}



interface Employee {
// Method to get the employee's name
String getName();
// Method to calculate the employee's monthly income
double calculateMonthlyIncome();
}

        
class PoliceMan implements Employee
{

    private String name;
    private PoliceManType type;

    public final static int HOURS_PER_WEEK = 160;
    
    public PoliceMan(String name, PoliceManType type)
    {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName()
    {	
        return name;
    }

    @Override
    public double calculateMonthlyIncome()
    {
        return HOURS_PER_WEEK * type.getPerHourRate() * 4;	
    }
}


enum PoliceManType
{
    OFFICERS(50), DETECTIVES(80);
    
    private final double PER_HOUR_RATE;

    private PoliceManType(double perHourRate)
    {
        PER_HOUR_RATE = perHourRate;
    }

    public double getPerHourRate()
    {
        return PER_HOUR_RATE; 
    }
}
