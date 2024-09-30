import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ArithmeticView {
    private VBox view;
    private TextField xField;
    private TextField yField;
    private Label sumLabel;

    private ArithmeticController controller;
    private ArithmeticModel model;

    public ArithmeticView(ArithmeticController controller, ArithmeticModel model) {

        this.controller = controller;
        this.model = model;

        createAndConfigurePane();
        createAndLayoutControls();
        updateControllerFromListeners();
        observeModelAndUpdateControls();
    }

    // In JavaFX, a Parent is an abstract class that represents a node in the scene graph that can have children. 
    // It serves as the base class for layout panes and other containers in JavaFX, such as Pane, HBox, VBox, BorderPane, GridPane, etc.
    // The Parent class provides methods for managing its children nodes, such as adding, removing, or getting children. 
    // It also defines properties related to layout and rendering, such as the layoutX, layoutY, layoutBounds, and boundsInParent.
    // Since Parent is an abstract class, you typically work with its subclasses, which include various layout panes and containers. 
    // These subclasses provide different layout behaviors, allowing you to create complex user interfaces by arranging UI components in different ways.
    public Parent asParent() {
        return view;
    }

    private void observeModelAndUpdateControls() {
        model.xProperty().addListener((obs, oldX, newX) -> updateIfNeeded(newX, xField));
        model.yProperty().addListener((obs, oldY, newY) -> updateIfNeeded(newY, yField));

        sumLabel.textProperty().bind(model.sumProperty().asString());
    }

    // If the given field has changed, update its text value.
    private void updateIfNeeded(Number value, TextField field) {
        String s = value.toString();
        if (!field.getText().equals(s)) {
            field.setText(s);
        }
    }

    private void updateControllerFromListeners() {
        xField.textProperty().addListener((obs, oldText, newText) -> controller.updateX(newText));
        yField.textProperty().addListener((obs, oldText, newText) -> controller.updateY(newText));
    }

    private void createAndLayoutControls() {
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

    private void createAndConfigurePane() {
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
}