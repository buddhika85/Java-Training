public abstract class Property extends Record
{
    protected Agent agent;
    protected String owner;
    protected double price;     //rental or sale price
    protected Status status;
    protected PropertyType propertyType;
    
    protected Property(int id, Agent agent, String owner, double price, PropertyType propertyType, Status status)
    {
        super(id);
        this.agent = agent;
        this.owner = owner;
        this.price = price;
        this.propertyType = propertyType;
        this.status = status;
    }   
    
    public double income()
    {
        if (status == status.VACANT)
            return 0.0;
        return getIncome();
    }
    
    protected abstract double getIncome();
    
    /*
    public boolean isRentalProperty()
    {
        return propertyType == PropertyType.RENTAL;
    }
    
    public boolean isSalesProperty()
    {
        return propertyType == PropertyType.SALES;
    }*/
    
    public boolean isVacant()
    {
        return status == Status.VACANT;
    }
        
    @Override 
    public String toString()
    {
        String str = super.toString() + ", agent " + agent.toString() + ", owner " + owner + 
                        ", type " + propertyType + ", status " + status;
        if (propertyType == PropertyType.SALES)
        {
            str += ", Sales price " + price;
        }
        else
        {
            str += ", Rental price " + price;
        }
        return str;
    }
}