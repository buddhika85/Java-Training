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

public class CountSquared extends Application
{
    // Create a SimpleIntegerProperty to track the number of clicks.
    private SimpleIntegerProperty countProperty = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty countSquaredProperty = new SimpleIntegerProperty(0);
    private SimpleBooleanProperty countGtProperty = new SimpleBooleanProperty();

    public static void main(String[] args) {
        CountSquared.launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Count clicks - Properties");

        Label label = new Label();
        Label squaredLbl = new Label();
        Label gtLabel = new Label("It is less than or equal to 5");

        // This label will 'listen' to changes in `countProperty`
        Label oddEvenLabel = new Label();
        Button button = new Button("Increase count");

        // Bind the label's text property to the count property. This means that any
        // change to the value in `countProperty` is automatically reflected in the
        // label text.
        label.textProperty().bind(countProperty.asString("Clicked %d times.   "));

        // squared lbl
        countSquaredProperty.bind(countProperty.multiply(countProperty));
        squaredLbl.textProperty().bind(countSquaredProperty.asString("Count squared %d"));

        countGtProperty.bind(countProperty.greaterThan(5));
        //gtLabel.textProperty().bind(countGtProperty.asString());
        countGtProperty.addListener((observableValue, oldValue, newValue) -> {
            if (newValue)
            {
                gtLabel.setText("It is greater than 5");
            }
        });

        // Add a change listener to the count property.
        countProperty.addListener(
                (observableValue, oldValue, newValue) -> {

                    // set squred property
                    // countSquaredProperty.set(newValue.intValue() * newValue.intValue());

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

        HBox firstRow = new HBox(label, button);
        firstRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(5, firstRow, oddEvenLabel, squaredLbl, gtLabel);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
