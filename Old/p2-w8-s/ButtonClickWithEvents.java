import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonClickWithEvents extends Application {

    private int count;

    public static void main(String[] args) {
        ButtonClickWithProps.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Count clicks - Events");

        Label label = new Label();
        
        Label oddEvenLabel = new Label();
        Button button = new Button("Increase count");

        button.setOnAction(event -> {
            // Increment the count property. 
            ++count;
            // Here we have to update both labels
            label.setText("Clicked "  + count + " times.   ");

            if (count % 2 == 0) {
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
