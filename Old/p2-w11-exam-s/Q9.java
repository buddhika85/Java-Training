import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Q9 extends Application {
    // Create a SimpleIntegerProperty to track the number of clicks.
    private SimpleIntegerProperty countProperty = new SimpleIntegerProperty(0);

    public static void main(String[] args) {
        Q9.launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Count clicks");
        Label label = new Label();
        Label oddEvenLabel = new Label();
        Button button = new Button("Increase count");

        button.setOnAction(event -> {
            countProperty.set(countProperty.get() + 1);	
        });

        label.textProperty().bind(countProperty.asString("Clicked %d times. "));
        countProperty.addListener(
                (observableValue, oldValue, newValue) -> {
                    if (newValue.intValue() % 2 == 0) {
                        oddEvenLabel.setText("You've clicked an EVEN number of times. ");
                    } else {
                        oddEvenLabel.setText("You've clicked an ODD number of times. ");
                    }
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