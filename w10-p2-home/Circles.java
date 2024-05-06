import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Circles extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        // circle will be created inside a Pane (parent of VBox, HBox)
        //  reason why we use Pane? ability to precisely set location of the children nodes within the Pane
        // Pane allows for absolute positioning of elements, providing more control over the exact placement of graphics elements, which is essential for custom graphics layouts.
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 400);

        root.setOnMouseClicked(event -> {

            // Here x and y represent the x and y coordinates of the mouse click within the
            // Pane.
            double x = event.getSceneX();
            double y = event.getSceneY();

            // Draws a circle with centre at (x, y) and radius 20 pixelss.
            Circle circle = new Circle(x, y, 20);

            circle.setFill(javafx.scene.paint.Color.DARKRED);
            circle.setStroke(javafx.scene.paint.Color.BLACK);

            // When circle is clicked, let's set its colour to red.
            circle.setOnMouseClicked(circleClickEvent -> {
                circle.setFill(Paint.valueOf("Red"));

                // This is a crucial call, otherwise the colour won't be properly changed.
                // What we want to do is change the colour of an existing circle bright red when the user clicks on it.
                // Now clicking on the circle also means a click on the pane. 
                // So clicking the pane means that another circle is placed within the pane, covering the existing circle. 
                // We basically need to prevent the click event on the pane, which is what the call to the consume() method is for.
                circleClickEvent.consume();
            });

            // add circle to pane
            root.getChildren().add(circle);
        });

        primaryStage.setTitle("Click to Draw Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}