package iPhone;

public class IPhone 
{
    private Model model = Model.IPHONE_15_PRO;
    private Color color = Color.Black_Titanium;
    private Storage storage = Storage.ONE_TWO_EIGHT;
    
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Storage getStorage() {
        return storage;
    }
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
    
    private double getTotalPrice()
    {
        return model.getPrice() + storage.getPrice();
    }

    @Override
    public String toString() {
        return "IPhone [model=" + model + ", color=" + color + ", storage=" + storage + "]\nPrice: " + getTotalPrice();
    }

    
}
