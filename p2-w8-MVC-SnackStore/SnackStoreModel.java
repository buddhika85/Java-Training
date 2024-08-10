import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SnackStoreModel
{
    // fields of the model
    private final SimpleIntegerProperty pepsiQtyProperty = new SimpleIntegerProperty();
    private final SimpleIntegerProperty juiceQtyProperty = new SimpleIntegerProperty();
    private final SimpleDoubleProperty pepsiPriceProperty = new SimpleDoubleProperty();
    private final SimpleDoubleProperty juicePriceProperty = new SimpleDoubleProperty();
    private final SimpleDoubleProperty totalProperty = new SimpleDoubleProperty();

    public SnackStoreModel()
    {
        totalProperty.bind(pepsiPriceProperty.multiply(pepsiQtyProperty).add(
            juicePriceProperty.multiply(juiceQtyProperty)));
    }

    public final SimpleIntegerProperty pepsiQtyProperty() {
        return pepsiQtyProperty;
    }

    public final SimpleIntegerProperty juiceQtyProperty() {
        return juiceQtyProperty;
    }

    public final SimpleDoubleProperty pepsiPriceProperty() {
        return pepsiPriceProperty;
    }

    public final SimpleDoubleProperty juicePriceProperty() {
        return juicePriceProperty;
    }

    public final SimpleDoubleProperty totalProperty() {
        return totalProperty;
    }

    public final int getPepsiQty() {
        return pepsiQtyProperty.get();
    }

    public final int getJiceQty() {
        return juiceQtyProperty.get();
    }

    public final double getPepsiPrice() {
        return pepsiPriceProperty.get();
    }

    public final double getJuicePrice() {
        return juicePriceProperty.get();
    }

    public final double getTotal() {
        return totalProperty.get();
    }

    // setters
    public final void setPepsiQty(final int pepsiQty) {
        pepsiQtyProperty.set(pepsiQty);
    }

    public final void setJiceQty(final int juiceQty) {
        juiceQtyProperty.set(juiceQty);
    }

    public final void setPepsiPrice(final double pepsiPrice) {
        pepsiPriceProperty.set(pepsiPrice);
    }

    public final void setJuicePrice(final double juicePrice) {
        juicePriceProperty.set(juicePrice);
    }

    // no setter for total
}