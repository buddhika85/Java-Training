import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXEventListenersExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a TextField
        TextField textField = new TextField("Initial Text");

        // Create a Label
        Label label = new Label(textField.getText());

        // Set up an event listener to update the Label when the TextField changes
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            label.setText(newValue);
        });

        // Create a VBox layout and add the TextField and Label
        VBox vbox = new VBox(textField, label);
        
        // Create a Scene and set it on the Stage
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Event Listeners Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
