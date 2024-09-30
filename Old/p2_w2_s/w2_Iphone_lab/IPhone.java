public class IPhone 
{
    private Model model = Model.IPHONE_15_PRO;
    private Colour colour = Colour.Black_Titanium;
    private Storage storage = Storage.ONE_TWO_EIGHT;
    

    public double calculatePrice()
    {
        return model.getPrice() + storage.getPrice();
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }    


    @Override
    public String toString() 
    {
        return "IPhone \n[model=" + model + 
            ", colour=" + colour + 
            ", storage=" + storage + "]\n Price = " + calculatePrice();
    }          
}