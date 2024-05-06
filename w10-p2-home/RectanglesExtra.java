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

public class RectanglesExtra extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        // root most node is a VBox
        VBox root = new VBox(5);

        Pane pane = new Pane();
        Scene scene = new Scene(root, 400, 400);

        pane.setOnMouseClicked(event -> {

            // Here x and y represent the x and y coordinates of the mouse click within the
            // Pane.
            double x = event.getSceneX();
            double y = event.getSceneY();

            // Draws a rectangle with centre at (x, y) and width and height
            Rectangle rectangle = new Rectangle(x, y, 40, 20);

            rectangle.setFill(javafx.scene.paint.Color.INDIGO);
            rectangle.setStroke(javafx.scene.paint.Color.BLACK);

            // When rectangle is clicked, let's set its colour to red.
            rectangle.setOnMouseClicked(rectangleClickEvent -> {
                rectangle.setFill(Paint.valueOf("Orange"));

                // This is a crucial call, otherwise the colour won't be properly changed.
                rectangleClickEvent.consume();
            });

            pane.getChildren().add(rectangle);
        });

        Button growButton = new Button("Grow");
        growButton.setOnAction(event -> {
            for (Node n : pane.getChildren()) {
                if (n instanceof Rectangle) {
                    Rectangle r = (Rectangle) n;
                    r.setWidth(r.getWidth() * 5);
                    r.setHeight(r.getHeight() * 5);
                }
            }
        });
        Button shrinkButton = new Button("Shrink");
        shrinkButton.setOnAction(event -> {
            for (Node n : pane.getChildren()) {
                if (n instanceof Rectangle) {
                    Rectangle r = (Rectangle) n;
                    r.setWidth(r.getWidth() / 2);
                    r.setHeight(r.getHeight() / 2);
                }
            }
        });

        Button resetSizeButton = new Button("Reset size");
        resetSizeButton.setOnAction(event -> {
            for (Node n : pane.getChildren()) {
                if (n instanceof Rectangle) {
                    Rectangle r = (Rectangle) n;
                    r.setWidth(40);
                    r.setHeight(20);
                }
            }
        });

        HBox buttonRow = new HBox(5, growButton, shrinkButton, resetSizeButton);
        buttonRow.setAlignment(Pos.BOTTOM_CENTER);

        // pane and buttonRow are children of root node
        root.getChildren().addAll(pane, buttonRow);

        // pane should always be resized vertically to fill up the any free space of the window
        VBox.setVgrow(pane, Priority.ALWAYS);

        primaryStage.setTitle("Click to Draw rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}