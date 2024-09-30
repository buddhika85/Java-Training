public enum Sauce
{
    PIZZA(0.0),
    BBQ(0.0),
    CREAM_FRAICHE(1.25),
    NONE(0.0);

    private double addedCost;

    private Sauce(double addedCost)
    {
        this.addedCost = addedCost;
    }

    public double getCost()
    {
        return addedCost;
    }

    @Override
    public String toString()
    {
        return this.name() + " (cost $) " + this.addedCost + ")";
    }
}