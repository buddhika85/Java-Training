import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ArithmeticView 
{
    // root node
    private VBox view;

    // other non root nodes
    private TextField xField;
    private TextField yField;
    private Label sumLabel;

    // cotroller and view object references
    private ArithmeticController controller;
    private ArithmeticModel model;

    public ArithmeticView(ArithmeticController controller, ArithmeticModel model) 
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
        return view;            // return root node
    }

    // Observe the model properties and update nodes in the view if needed
    private void observeModelAndUpdateControls() 
    {
        // view nodes are observing properties in the model object and updating itself accordingly

        // when x, y properties of the model change, update vide accordingly
        model.xProperty().addListener((obs, oldX, newX) -> updateIfNeeded(newX, xField));
        model.yProperty().addListener((obs, oldY, newY) -> updateIfNeeded(newY, yField));

        // when models sum Property is updated, update sum label of the view accordingly
        sumLabel.textProperty().bind(model.sumProperty().asString());
    }

    // If the given field has changed, update its text value.
    private void updateIfNeeded(Number value, TextField field) {
        String s = value.toString();
        if (!field.getText().equals(s))             // is the fields current value is NOT equal to vew 'value' ?
        {
            field.setText(s);
        }
    }

    // when user inputs to view, send a notification to controller
    // controller will nofify model
    private void updateControllerFromListeners() 
    {
        xField.textProperty().addListener((obs, oldText, newText) -> controller.updateX(newText));
        yField.textProperty().addListener((obs, oldText, newText) -> controller.updateY(newText));
    }

    // create and align other non-root nodes
    private void createAndLayoutControls() 
    {
        xField = new TextField();
        configTextFieldForInts(xField);

        yField = new TextField();
        configTextFieldForInts(yField);

        sumLabel = new Label();

        HBox xRow = new HBox(5, new Label("X:"), xField);
        xRow.setAlignment(Pos.CENTER);

        HBox yRow = new HBox(5, new Label("Y:"), yField);
        yRow.setAlignment(Pos.CENTER);

        HBox sumRow = new HBox(5, new Label("Sum:"), sumLabel);
        sumRow.setAlignment(Pos.CENTER);

        view.getChildren().addAll(xRow, yRow, sumRow);
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
        // when field values change JavaFx will automatacally execute setTextFormatter logic below
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
}