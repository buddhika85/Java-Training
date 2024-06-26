public class SalesProperty extends Property
{
    private String buyer;
    private double actualSalePrice;
    
    public SalesProperty(int id, Agent agent, String owner, double price, String buyer, double actualSalePrice, Status status)
    {
        super(id, agent, owner, price, PropertyType.SALES, status );
        this.buyer = buyer;
        this.actualSalePrice = actualSalePrice;
    }
    
    public SalesProperty(int id, Agent agent, String owner, double price)
    {
        super(id, agent, owner, price, PropertyType.SALES, Status.VACANT);      
        //this.buyer = null;
        //this.actualSalePrice = 0.0;
    }  
    
    public void sell(String buyer, Agent agent, double actualSalePrice)
    {
        this.buyer = buyer;
        super.agent = agent;
        this.actualSalePrice = actualSalePrice;
        super.status = Status.SOLD;
    }
    
    // call this in the correct context - client supplier agreement
    @Override
    public double getIncome()
    {
        return actualSalePrice; 
    }
    
    @Override
    public String toString()
    {
        return "Sales Property " + super.toString() + ", buyer " + buyer + ", Actual Sale Price " + actualSalePrice;
    }
}
