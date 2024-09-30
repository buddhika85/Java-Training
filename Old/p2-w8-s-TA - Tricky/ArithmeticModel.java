import javafx.beans.property.SimpleIntegerProperty;

public class ArithmeticModel 
{
    // fields of the model
    private final SimpleIntegerProperty x = new SimpleIntegerProperty();
    private final SimpleIntegerProperty y = new SimpleIntegerProperty();
    private final SimpleIntegerProperty sum = new SimpleIntegerProperty();

    private SimpleIntegerProperty diff = new SimpleIntegerProperty();
    private SimpleIntegerProperty prod = new SimpleIntegerProperty();
    private SimpleIntegerProperty quotient = new SimpleIntegerProperty();

    public ArithmeticModel()
    {
        sum.bind(x.add(y));         // sum always = x's current value + y's current value
        diff.bind(x.subtract(y));
        prod.bind(x.multiply(y));

        x.addListener((obs, oldValue, newValue) -> recalculateQuotient());
        y.addListener((obs, oldValue, newValue) -> recalculateQuotient());
    }

    private void recalculateQuotient() 
    {
       if (getY() != 0)
       {
            quotient.set(getX() / getY());
       }
       else
       {
            quotient.set(0);
       }
    }

    // for X getters /accessors
    public final SimpleIntegerProperty xProperty() 
    {
        return this.x;
    }

    public final int getX() 
    {
        return this.xProperty().get();
    }

    // X mutator
    public final void setX(final int x) {
        this.xProperty().set(x);
    }

    // for y getters /accessors
    public final SimpleIntegerProperty yProperty() {
        return this.y;
    }

    public final int getY() {
        return this.yProperty().get();
    }

    // Y mutator
    public final void setY(final int y) {
        this.yProperty().set(y);
    }

    // Sum getters
    public final SimpleIntegerProperty sumProperty() {
        return this.sum;
    }

    public final int getSum() {
        return this.sumProperty().get();
    }

    // diff getters
    public final SimpleIntegerProperty diffProperty() {
        return this.diff;
    }

    public final int getDiff() {
        return this.diffProperty().get();
    }

    // prod
    public final SimpleIntegerProperty prodProperty() {
        return this.prod;
    }

    public final int getProd() {
        return this.prodProperty().get();
    }

    // quotient
    public final SimpleIntegerProperty quotientProperty() {
        return this.quotient;
    }

    public final int getQuotient() {
        return this.quotientProperty().get();
    }
}