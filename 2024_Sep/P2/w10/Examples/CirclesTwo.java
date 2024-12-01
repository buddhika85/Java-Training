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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CirclesTwo extends Application 
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

            // Draws a circle with centre at (x, y) and radius 20.
            Circle circle = new Circle(x, y, 20);

            circle.setFill(javafx.scene.paint.Color.DARKRED);
            circle.setStroke(javafx.scene.paint.Color.BLACK);

            // When circle is clicked, let's set its colour to red.
            circle.setOnMouseClicked(circleClickEvent -> {
                circle.setFill(Paint.valueOf("Red"));

                // This is a crucial call, otherwise the colour won't be properly changed.
                circleClickEvent.consume();
            });

            pane.getChildren().add(circle);
        });

        Button growButton = new Button("Grow");
        growButton.setOnAction(event -> 
        {
            for (Node n : pane.getChildren())       // get all child nodes
            {
                if (n instanceof Circle) 
                {
                    Circle c = (Circle) n;
                    double currentRadius = c.getRadius();
                    c.setRadius(currentRadius * 1.1);       // increase radius by 1.1 times
                }
            }
        });
        Button shrinkButton = new Button("Shrink");
        shrinkButton.setOnAction(event -> {
            for (Node n : pane.getChildren()) {
                if (n instanceof Circle) {
                    Circle c = (Circle) n;
                    double currentRadius = c.getRadius();
                    c.setRadius(currentRadius * 0.9);       // increase radius by 0.9 times
                }
            }
        });

        Button resetSizeButton = new Button("Reset size");
        resetSizeButton.setOnAction(event -> {
            for (Node n : pane.getChildren()) {
                if (n instanceof Circle) {
                    Circle c = (Circle) n;
                    c.setRadius(20.0);                      // set the radius by 20 pixels
                }
            }
        });

        HBox buttonRow = new HBox(5, growButton, shrinkButton, resetSizeButton);
        buttonRow.setAlignment(Pos.BOTTOM_CENTER);
        root.getChildren().addAll(pane, buttonRow);   // root is VBox - single column layout


        // ensures that the pane grows vertically to fill available space within its VBox (parent container) container
        // so initially it makes sure that Pane takes full possible amount of height from its Vbox container
        // ParentNodeType.setVgrow(childNode, Priority.ALWAYS);
        VBox.setVgrow(pane, Priority.ALWAYS);

        primaryStage.setTitle("Click to Draw Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



/*
 * 
 * 
 * The grow priority has three possible values from the Priority enum:

Priority.NEVER:
The child will not grow to take up extra space.


Priority.SOMETIMES:
The child will grow if there's extra space, but only if no other nodes with Priority.ALWAYS need the space.


Priority.ALWAYS:
The child will always grow to take up as much available space as possible.
 */