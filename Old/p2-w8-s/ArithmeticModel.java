import javafx.beans.property.SimpleIntegerProperty;

public class ArithmeticModel 
{
    // fields of the model
    private final SimpleIntegerProperty x = new SimpleIntegerProperty();
    private final SimpleIntegerProperty y = new SimpleIntegerProperty();
    private final SimpleIntegerProperty sum = new SimpleIntegerProperty();

    public ArithmeticModel()
    {
        sum.bind(x.add(y));         // sum always = x's current value + y's current value
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
}