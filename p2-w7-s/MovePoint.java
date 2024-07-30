import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovePoint extends Application {

    // Coordinates of our point
    private int x, y;

    private Label lbl;

    public static void main(String[] args) 
    {
        MovePoint.launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Move point");
        lbl = new Label();
        updateLbl();

        int horizontalAlignment = 5;

        // increment row
        Button increaseXBtn = new Button("Increase X");
        increaseXBtn.setOnAction(e -> {
            ++x;
            updateLbl();
        });
        Button increaseYBtn = new Button("Increase Y");
        increaseYBtn.setOnAction(e -> {
            ++y;
            updateLbl();
        });
        HBox increaseRow = new HBox(horizontalAlignment, increaseXBtn, increaseYBtn);
        increaseRow.setAlignment(Pos.CENTER);

        // decrement row
        Button decreaseXBtn = new Button("Decrease X");
        decreaseXBtn.setOnAction(e -> {
            --x;
            updateLbl();
        });
        Button decreaseYBtn = new Button("Decrease Y");
        decreaseYBtn.setOnAction(e -> {
            --y;
            updateLbl();
        });
        HBox decreaseRow = new HBox(horizontalAlignment, decreaseXBtn, decreaseYBtn);
        decreaseRow.setAlignment(Pos.CENTER);

        int verticalPadding = 5;
        VBox root = new VBox(verticalPadding, lbl, increaseRow, decreaseRow);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateLbl() 
    {
        lbl.setText("(" + x + "," + y + ")");
    }
}