class Employee
{
	protected int id;
	protected String name;
	protected String address;

	public Employee(int id, String name, String address)
	{
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString()
	{
		return id + " " + name + " " + address;
	}
}

class HourlyEmployee extends Employee
{
	private double rate;

	public HourlyEmployee(int id, String name, String address, double rate)
	{
		super(id, name, address);
		this.rate = rate;
	}

	public double weeklyPay(double hours)
	{
		// logic
		return hours * rate;
	}

	@Override
	public String toString()
	{
		return super.toString() + " " + rate;
	}
}