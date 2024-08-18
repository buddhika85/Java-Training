import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SnackStoreView 
{
    // root node
    private VBox view;

    // other non root nodes
    private TextField pepsiQtyField;
    private TextField juiceQtyField;
    private TextField pepsiPriceField;
    private TextField juicePriceField;
    private Label totalLabel;

    // cotroller and view object references
    private SnackStoreController controller;
    private SnackStoreModel model;

    public SnackStoreView(SnackStoreController controller, SnackStoreModel model) 
    {

        // intialize controller and model objects
        this.controller = controller;
        this.model = model;

        createAndConfigurePane();           // create root node, align it
        createAndLayoutControls();          // crteate and add other non-root nodes to root
        updateControllerFromListeners();    // notify conreoller when view received new input from user
        observeModelAndUpdateControls();    // observe property changes in model and update controls in the view accordingly
    }

    // return root node back to caller
    public Parent asParent() 
    {
        return view;
    }

    // Observe the model properties and update nodes in the view if needed
    private void observeModelAndUpdateControls() 
    {
        model.pepsiQtyProperty().addListener((obs, oldValue, newValue) -> updateIfNeeded(newValue, pepsiQtyField));
        model.pepsiPriceProperty().addListener((obs, oldValue, newValue) -> updateIfNeeded(newValue, pepsiPriceField));
        model.juiceQtyProperty().addListener((obs, oldValue, newValue) -> updateIfNeeded(newValue, juiceQtyField));
        model.juicePriceProperty().addListener((obs, oldValue, newValue) -> updateIfNeeded(newValue, juicePriceField));

        totalLabel.textProperty().bind(model.totalProperty().asString("Total price: $%.2f"));
    }

    // If the given field has changed, update its text value.
    private void updateIfNeeded(Number value, TextField field) {
        String s = value.toString();
        if (!field.getText().equals(s)) {
            field.setText(s);
        }
    }

    // when user inputs to view, send a notification to controller
    // controller will nofify model
    private void updateControllerFromListeners() 
    {
        pepsiQtyField.textProperty().addListener((obs, oldText, newText) -> controller.updatePepsiQty(newText));
        pepsiPriceField.textProperty().addListener((obs, oldText, newText) -> controller.updatePepsiPrice(newText));
        juiceQtyField.textProperty().addListener((obs, oldText, newText) -> controller.updateJuiceQty(newText));
        juicePriceField.textProperty().addListener((obs, oldText, newText) -> controller.updateJuicePrice(newText));
    }

    // create and align other non-root nodes
    private void createAndLayoutControls() 
    {
        pepsiQtyField = new TextField();
        configTextFieldForInts(pepsiQtyField);

        juiceQtyField = new TextField();
        configTextFieldForInts(juiceQtyField);

        pepsiPriceField = new TextField();
        configTextFieldForDoubles(pepsiPriceField);

        juicePriceField = new TextField();
        configTextFieldForDoubles(juicePriceField);

        totalLabel = new Label();

        HBox pepsiRow = new HBox(5, 
            new Label("Pepsi Qty:"), pepsiQtyField,
            new Label("Price per bottle:"), pepsiPriceField);
        pepsiRow.setAlignment(Pos.CENTER);

        HBox juiceRow = new HBox(5, 
            new Label("Juice Qty:"), juiceQtyField,
            new Label("Price per bottle:"), juicePriceField);
        juiceRow.setAlignment(Pos.CENTER);
       
        HBox sumRow = new HBox(5, totalLabel);
        sumRow.setAlignment(Pos.CENTER);

        view.getChildren().addAll(pepsiRow, juiceRow, sumRow);
    }

    // create root node
    private void createAndConfigurePane() 
    {
        view = new VBox(5);
        view.setAlignment(Pos.CENTER);
    }

    // You may skip looking at this method. Its purpose is to ensure that
    // only integers can be entered into the X and Y text fields. You may find this
    // useful in your project B!
    private void configTextFieldForInts(TextField field) {
        field.setTextFormatter(new TextFormatter<Integer>((Change c) -> {
            // "-?\\d*" is called a regular expression. For those who are curious:
            //
            // - The "-?" indicates that the minus sign is optionally present (we need to
            // allow for negative integers too)
            // - "\\d" is a digit character, which matches any digit from 0 to 9.
            // - The following "*" is a quantifier that means "zero or more occurrences".
            // - Therefore, \\d* matches a sequence of zero or more digits.
            if (c.getControlNewText().matches("-?\\d*")) {
                return c;
            }
            return null;
        }));
    }

    private void configTextFieldForDoubles(TextField field) {
        field.setTextFormatter(new TextFormatter<Integer>((Change c) -> {
            if (c.getControlNewText().matches("\\d+.?\\d*")) {
                return c;
            }
            return null;
        }));
    }
}
