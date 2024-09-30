public class Q8 {
    public static void main(String[] args) {
        for (PoliceManType type : PoliceManType.values())
        {
            PoliceMan policeMan = new PoliceMan(type.name(), type);
            System.out.println(policeMan.getName() + " earns $ " + policeMan.calculateMonthlyIncome());    
        }
    }
}


enum PoliceManType
{
	OFFICER(50),
	DETECTIVE(80);

	private double rate;

	private PoliceManType(double rate)
	{
		this.rate = rate;
	}

	public double getRate()
	{
		return this.rate;
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
	private PoliceManType policeManType;
	private static final int HOURS_PER_WEEK = 160;

    public PoliceMan(String name, PoliceManType policeManType)
	{
		this.name = name;
		this.policeManType = policeManType;
	}

	public String getName()
	{
		return name;
	}

	public double calculateMonthlyIncome()
	{
		return HOURS_PER_WEEK * policeManType.getRate() * 4;
	}
}