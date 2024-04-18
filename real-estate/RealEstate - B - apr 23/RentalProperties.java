public class RentalProperties extends Properties
{
    @Override
    public RentalProperty find(int id)
    {
        return (RentalProperty) super.find(id);
    }
    
    public void add(Agent agent, String owner, double price)
    {  
        RentalProperty property  = new RentalProperty(++id, agent, owner, price);        
        super.add(property);
        System.out.println("\tRental Property Added - " + property.toString());
    } 
    
    @Override
    public String toString()
    {
        return "Rental Properties\n" + super.toString(); 
    }
}
