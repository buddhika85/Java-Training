enum Sauce
{
    PIZZA(0.0),
    BBQ(0.0),
    CREAM_FRAICHE(3.25),
    NONE(0.0);

    private double addedCost;

    
    Sauce(double addedCost)
    {
        this.addedCost = addedCost;
    }


    public double getAddedCost() {
        return addedCost;
    }

    public void setAddedCost(double addedCost) {
        this.addedCost = addedCost;
    }

    @Override
    public String toString()
    {
        // this.name() --> Returns the name of this enum constant, exactly as declared in its enum declaration.
        return this.name() + " costs $:" + addedCost;
    }

}