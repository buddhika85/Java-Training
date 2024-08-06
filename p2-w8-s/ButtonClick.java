import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonClick extends Application 
{

    // This attribute will track the number of times the button is clicked.
    private int count;

    public static void main(String[] args) {
        ButtonClick.launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Count clicks");

        this.count = 0;

        Label label = new Label("No clicks yet.   ");
        Button button = new Button("Increase count");

        button.setOnAction(event -> {
            // We need to update the `count` attribute
            this.count += 1;

            // And we must also update the `label` text to display the new
            // value of `count`.
            label.setText("Clicked " + this.count + " times.   ");
        });

        HBox root = new HBox(label, button);

        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}