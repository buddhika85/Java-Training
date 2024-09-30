import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXPropertiesExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a StringProperty
        StringProperty textProperty = new SimpleStringProperty("Initial Text");

        // Create a TextField and bind its text property to the StringProperty
        TextField textField = new TextField();
        textField.textProperty().bindBidirectional(textProperty);

        // Create a Label and bind its text property to the StringProperty
        Label label = new Label();
        label.textProperty().bind(textProperty);

        // Create a VBox layout and add the TextField and Label
        VBox vbox = new VBox(textField, label);
        
        // Create a Scene and set it on the Stage
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Properties Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
