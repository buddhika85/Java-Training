import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovePoint extends Application 
{
    private static final int PADDING = 5;
    private int x, y;
    private Label resultLbl = new Label();
    private Button increaseX = new Button("Increase x");
    private Button increaseY = new Button("Increase y");
    private Button decreaseX = new Button("Decrease x");
    private Button decreaseY = new Button("Decrease Y");

    public static void main(String[] args) 
    {
        launch(args);    
    }    

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Move point");    

        updateLbl();        // label

        // button click events
        increaseX.setOnAction(e -> onIncreaseXClick());
        increaseY.setOnAction(e -> onIncreaseYClick());
        decreaseX.setOnAction(e -> onDecreaseXClick());
        decreaseY.setOnAction(e -> onDecreaseYClick());

        // increase row
        HBox increaseRow = new HBox(PADDING, increaseX, increaseY);
        increaseRow.setAlignment(Pos.CENTER);

        // decrease row
        HBox decreaseRow = new HBox(PADDING, decreaseX, decreaseY);
        decreaseRow.setAlignment(Pos.CENTER);
        
        VBox root = new VBox(PADDING, resultLbl, increaseRow, decreaseRow);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateLbl()
    {
        resultLbl.setText(getLblTxt());
    }

    private String getLblTxt() 
    {
        return "(" + x + "," + y + ")";
    }

    private void onIncreaseXClick() 
    {
        ++x;
        updateLbl();
    }

    private void onIncreaseYClick() 
    {
        ++y;
        updateLbl();
    }

    private void onDecreaseXClick() 
    {
        --x;
        updateLbl();
    }

    private void onDecreaseYClick() 
    {
        --y;
        updateLbl();
    }
}