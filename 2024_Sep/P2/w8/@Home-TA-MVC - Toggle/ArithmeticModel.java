import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ArithmeticModel 
{
    // fields of the model
    private final SimpleIntegerProperty x = new SimpleIntegerProperty();
    private final SimpleIntegerProperty y = new SimpleIntegerProperty();
    private final SimpleIntegerProperty sum = new SimpleIntegerProperty();
    private final SimpleIntegerProperty diff = new SimpleIntegerProperty();
    private final SimpleIntegerProperty product = new SimpleIntegerProperty();
    private final SimpleIntegerProperty quotient = new SimpleIntegerProperty();    

    private final SimpleObjectProperty<Operation> selectedOperation = new SimpleObjectProperty<>(null);
    private final SimpleIntegerProperty result = new SimpleIntegerProperty();    

    public ArithmeticModel()
    {
        sum.bind(x.add(y));         // sum always = x's current value + y's current value
        diff.bind(x.subtract(y));
        product.bind(x.multiply(y));       
        y.addListener((obs, oldValue, newValue) -> {
            if (newValue.intValue() > 0)
            {
                quotient.bind(x.divide(y));
            }
        });

        selectedOperation.addListener((obs, oldValue, newValue) -> {
            if (newValue == null)
                return;
            if (newValue == Operation.ADDITION)
                result.bind(sum);
            if (newValue == Operation.SUBTRACTION)
                result.bind(diff);
            if (newValue == Operation.MUTLTIPLICATION)
                result.bind(product);
            if (newValue == Operation.DVIVISION)
                result.bind(quotient);
        });
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

    // diff
    public final SimpleIntegerProperty diffProperty() {
        return this.diff;
    }

    public final int getDiff() {
        return this.diffProperty().get();
    }

    // prod
    public final SimpleIntegerProperty prodProperty() {
        return this.product;
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

    // result
    public final SimpleIntegerProperty resultProperty() {
        return this.result;
    }

    public final int getResult() {
        return this.resultProperty().get();
    }

    // mutator for selectedOperation
    public final void setSelectedOperation(Operation operation) {
        selectedOperation.set(operation);
    }
}