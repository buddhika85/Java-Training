public class SalesProperties extends Properties
{
    @Override
    public SalesProperty find(int id)
    {
        return (SalesProperty) super.find(id);
    }
    
    public void add(Agent agent, String owner, double price)
    {  
        SalesProperty property  = new SalesProperty(++id, agent, owner, price);        
        super.add(property);
        System.out.println("\tSales Property Added - " + property.toString());
    } 
    
    @Override
    public String toString()
    {
        return "Sales Properties\n" + super.toString(); 
    }
}