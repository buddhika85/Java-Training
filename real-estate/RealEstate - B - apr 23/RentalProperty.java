public class RentalProperty extends Property
{
    private String tenant;
    
    public RentalProperty(int id, Agent agent, String owner, double price, String tenant, Status status)
    {
        super(id, agent, owner, price, PropertyType.RENTAL , status);      
        this.tenant = tenant;
    }
    
    public RentalProperty(int id, Agent agent, String owner, double price)
    {
        super(id, agent, owner, price, PropertyType.RENTAL, Status.VACANT );
        //this.tenant = null;
    }  
    
    public void rent(String tenant, Agent agent)
    {
        this.tenant = tenant;
        super.agent = agent;
        super.status = Status.RENTED;
    }
    
    // call this in the correct context - client supplier agreement
    @Override
    public double getIncome()
    {
        return price; 
    }
    
    @Override
    public String toString()
    {
        return "Rental Property " + super.toString() + ", tenant " + tenant;
    }
}