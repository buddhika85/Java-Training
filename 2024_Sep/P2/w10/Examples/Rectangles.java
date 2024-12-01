import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Rectangles extends Application 
{

    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        VBox root = new VBox(5);            // This time root is a VBox

        Pane pane = new Pane();
        Scene scene = new Scene(root, 400, 400);

        pane.setOnMouseClicked(event -> {

            // Here x and y represent the x and y coordinates of the mouse click within the
            // Pane.
            double x = event.getSceneX();
            double y = event.getSceneY();

            // Draws a Rectangle with centre at (x, y) and width and height
            Rectangle rectangle = new Rectangle(x, y, 25, 50);         // w, h

            rectangle.setFill(javafx.scene.paint.Color.DARKRED);
            rectangle.setStroke(javafx.scene.paint.Color.BLACK);

            // When rectangle is clicked, let's set its colour to red.
            rectangle.setOnMouseClicked(clickEvent -> {
                rectangle.setFill(Paint.valueOf("Red"));

                // This is a crucial call, otherwise the colour won't be properly changed.
                clickEvent.consume();
            });

            pane.getChildren().add(rectangle);
        });

        Button growButton = new Button("Grow");
        growButton.setOnAction(event -> 
        {
            for (Node n : pane.getChildren())       // get all child nodes
            {
                if (n instanceof Rectangle) 
                {
                    Rectangle r = (Rectangle) n;                    
                    r.setHeight(r.getHeight() * 1.5);
                    r.setWidth(r.getWidth() * 1.5);
                }
            }
        });

        Button shrinkButton = new Button("Shrink");
        shrinkButton.setOnAction(event -> {
            for (Node n : pane.getChildren())       
            {
                if (n instanceof Rectangle) 
                {
                    Rectangle r = (Rectangle) n;                    
                    r.setHeight(r.getHeight() * 0.5);
                    r.setWidth(r.getWidth() * 0.5);
                }
            }
        });

        Button resetSizeButton = new Button("Reset size");
        resetSizeButton.setOnAction(event -> {
            for (Node n : pane.getChildren())       // get all child nodes
            {
                if (n instanceof Rectangle) 
                {
                    Rectangle r = (Rectangle) n;                    
                    r.setHeight(50);
                    r.setWidth(25);
                }
            }
        });

        HBox buttonRow = new HBox(5, growButton, shrinkButton, resetSizeButton);
        buttonRow.setAlignment(Pos.BOTTOM_CENTER);
        root.getChildren().addAll(pane, buttonRow);   // root is VBox - single column layout


        // ensures that the pane grows vertically to fill available space within its VBox (parent container) container
        // so initially it makes sure that Pane takes full possible amount of height from its Vbox container
        VBox.setVgrow(pane, Priority.ALWAYS);

        primaryStage.setTitle("Click to Draw Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}