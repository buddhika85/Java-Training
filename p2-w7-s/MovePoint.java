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

    // Coordinates of our point
    private int x = 0, y = 0;
    private Label pointLbl;

    public static void main(String[] args) 
    {
        MovePoint.launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Move point");
        pointLbl = new Label();
        updateLabel();

        int horizontalPadding = 5, verticalPadding = 5;

        // increase row
        Button incXBtn = new Button("Increase X");
        incXBtn.setOnAction(event -> {
            ++x;
            updateLabel();
        });
        Button incYBtn = new Button("Increase Y");
        incYBtn.setOnAction(event -> {
            ++y;
            updateLabel();
        });
        HBox incBtnsRow = new HBox(horizontalPadding, incXBtn, incYBtn);
        incBtnsRow.setAlignment(Pos.CENTER);

        // decrease row
        Button decXBtn = new Button("Decrease X");
        decXBtn.setOnAction(event -> {
            --x;
            updateLabel();
        });
        Button decYBtn = new Button("Decrease Y");
        decYBtn.setOnAction(event -> {
            --y;
            updateLabel();
        });
        HBox decBtnsRow = new HBox(horizontalPadding, decXBtn, decYBtn);
        decBtnsRow.setAlignment(Pos.CENTER);

        // root
        VBox root = new VBox(verticalPadding, pointLbl, incBtnsRow, decBtnsRow);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateLabel() 
    {
        pointLbl.setText("(" + x + ", " + y + ")");
    }
}


class Point
{
    private int x, y;

    public Point(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }
   
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}