import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Rectangles extends Application 
{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        // rectangle will be created inside a Pane (parent of VBox, HBox)
        //  reason why we use Pane? ability to precisely set location of the children nodes within the Pane
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 400);

        root.setOnMouseClicked(event -> {

            double x = event.getSceneX();
            double y = event.getSceneY();

            // Draws a rectangle
            Rectangle rectangle = new Rectangle(x, y, 50, 150);             // x, y, Width, Height

            rectangle.setFill(javafx.scene.paint.Color.DARKBLUE);
            rectangle.setStroke(javafx.scene.paint.Color.BLACK);

            // When rectangle is clicked, let's set its colour to red.
            rectangle.setOnMouseClicked(rectangleClickedEvent -> {
                rectangle.setFill(Paint.valueOf("Green"));

                // This is a crucial call, otherwise the colour won't be properly changed.
                // What we want to do is change the colour of an existing rectangle bright red when the user clicks on it.
                // Now clicking on the rectangle also means a click on the pane. 
                // So clicking the pane means that another rectangle is placed within the pane, covering the existing rectangle. 
                // We basically need to prevent the click event on the pane, which is what the call to the consume() method is for.
                rectangleClickedEvent.consume();
            });

            // add rectangle to pane
            root.getChildren().add(rectangle);
        });

        primaryStage.setTitle("Click to Draw rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}