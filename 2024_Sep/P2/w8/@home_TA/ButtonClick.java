import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonClick extends Application {

    // Create a SimpleIntegerProperty to track the number of clicks.
    private SimpleIntegerProperty countProperty = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty countSquaredProperty = new SimpleIntegerProperty(0);
    private SimpleBooleanProperty  gtFiveProperty = new SimpleBooleanProperty(false);

    public static void main(String[] args) {
        ButtonClick.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Count clicks");

        Label label = new Label();
        Label labelSqrd = new Label();
        Label labelGtFive = new Label();
        Label label2GtFive = new Label("It is not greater than 5");

        // This label will 'listen' to changes in `countProperty`
        Label oddEvenLabel = new Label();
        Button button = new Button("Increase count");

        // Bind the label's text property to the count property. This means that any
        // change to the value in `countProperty` is automatically reflected in the
        // label text.
        label.textProperty().bind(countProperty.asString("Clicked %d times.   "));
        labelSqrd.textProperty().bind(countSquaredProperty.asString("Squred == %d"));
        labelGtFive.textProperty().bind(gtFiveProperty.asString());

        // Add a change listener to the count property.
        countProperty.addListener(
                (observableValue, oldValue, newValue) -> {
                    if (newValue.intValue() % 2 == 0) {
                        oddEvenLabel.setText("You've clicked an EVEN number of times. ");
                    } else {
                        oddEvenLabel.setText("You've clicked an ODD number of times. ");
                    }
                });

        button.setOnAction(event -> {
            // Increment the count property. Notice how we don't need to update the label
            // anymore.
            countProperty.set(countProperty.get() + 1);
        });

        gtFiveProperty.addListener((obsValue, oldValue, newValue) -> {
            if (newValue.booleanValue())
            {
                label2GtFive.setText("It is greater than 5");
            }
        });

        countSquaredProperty.bind(countProperty.multiply(countProperty));
        gtFiveProperty.bind(countProperty.greaterThan(5));

        HBox firstRow = new HBox(label, button);
        firstRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(5, firstRow, oddEvenLabel, labelSqrd, labelGtFive, label2GtFive);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}