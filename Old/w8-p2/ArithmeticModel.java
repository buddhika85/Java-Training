import javafx.beans.property.SimpleIntegerProperty;

public class ArithmeticModel {
    private final SimpleIntegerProperty x = new SimpleIntegerProperty();
    private final SimpleIntegerProperty y = new SimpleIntegerProperty();
    private final SimpleIntegerProperty sum = new SimpleIntegerProperty();

    public ArithmeticModel() {
        sum.bind(x.add(y));
    }

    public final SimpleIntegerProperty xProperty() {
        return this.x;
    }

    public final int getX() {
        return this.xProperty().get();
    }

    public final void setX(final int x) {
        this.xProperty().set(x);
    }

    public final SimpleIntegerProperty yProperty() {
        return this.y;
    }

    public final int getY() {
        return this.yProperty().get();
    }

    public final void setY(final int y) {
        this.yProperty().set(y);
    }

    public final SimpleIntegerProperty sumProperty() {
        return this.sum;
    }

    public final int getSum() {
        return this.sumProperty().get();
    }
}