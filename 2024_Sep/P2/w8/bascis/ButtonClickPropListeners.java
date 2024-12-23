import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonClickPropListeners extends Application {

    // Create a SimpleIntegerProperty to track the number of clicks.
    // an observable container for storing integers
    private SimpleIntegerProperty countProperty = new SimpleIntegerProperty(0);

    public static void main(String[] args) {
        ButtonClickPropListeners.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Count clicks");

        Label label = new Label();

        // This label will 'listen' to changes in `countProperty`
        Label oddEvenLabel = new Label();
        Button button = new Button("Increase count");

        // Bind the label's text property to the count property. This means that any
        // change to the value in `countProperty` is automatically reflected in the
        // label text.
        label.textProperty().bind(countProperty.asString("Clicked %d times.   "));

        // Add a change listener to the count property.
        // this listens to the changes of countProperty (a container)
        // so when the value of count property changes, this will be executed by JavaFX autmatically
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

        HBox firstRow = new HBox(label, button);
        firstRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(5, firstRow, oddEvenLabel);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}