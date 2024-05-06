import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CircleAnimate extends Application 
{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        VBox root = new VBox(5);

        Pane pane = new Pane();
        
        int sceneWidth = 600;
        int sceneHeight = 600;
        Scene scene = new Scene(root, sceneWidth, sceneHeight);


        // start circle animation
        Circle movingCircle = new Circle(10);
        movingCircle.setFill(Color.ORANGERED);

        Circle pathCircle = new Circle(100);
        pathCircle.setStroke(javafx.scene.paint.Color.BLACK);
        pathCircle.setFill(null); // Don't fill in the circle with any colour
        pathCircle.setCenterX(150);
        pathCircle.setCenterY(150);

        // The PathTransition class allows for nodes to smoothly move along a Path. This path can be set by any class that extends :Shape
        PathTransition transition = new PathTransition();
        transition.setNode(movingCircle);                                   // set which node to be animated?
        transition.setDuration(Duration.seconds(4));                        // for how long ?
        transition.setPath(pathCircle);                                     // animation path ? Here movingCircle will follow the path set by pathCircle.

        // animation progresses evenly from the start to the end without any acceleration or deceleration.
        transition.setInterpolator(Interpolator.LINEAR);                  // rate of change of the animation. In our case LINEAR means a constant rate of motion. - Try out the: EASE_IN, EASE_OUT, EASE_BOTH.
        // other options possible
        //transition.setInterpolator(Interpolator.EASE_IN);                 // animation starts slowly and accelerates as it progresses towards the end.
        //transition.setInterpolator(Interpolator.EASE_OUT);                // animation starts quickly and decelerates as it approaches the end.
        //transition.setInterpolator(Interpolator.EASE_BOTH);               // animation starts slowly, accelerates in the middle, and then decelerates towards the end
        
        transition.setCycleCount(PathTransition.INDEFINITE);                // Sets the number of times the animation should repeat. In our case we set an infinite loop on the animation.
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);            //  it says that the node will always align perpendicular (90 degrees) to the tangent of the path 

             
        // end circle animation


        // start rectangle animation
        Rectangle movingRectangle = new Rectangle(25, 10);         // W, H
        movingRectangle.setFill(Color.GREEN);

        Rectangle pathRectangle = new Rectangle(100, 100);                // W, H, X, Y
        pathRectangle.setStroke(javafx.scene.paint.Color.BLACK);
        pathRectangle.setFill(null); // Don't fill in the circle with any colour
        pathRectangle.setX(400);
        pathRectangle.setY(400);

        PathTransition transitionRect = new PathTransition();
        transitionRect.setNode(movingRectangle);                                    // set which node to be animated?
        transitionRect.setDuration(Duration.seconds(4));                            // for how long ?
        transitionRect.setPath(pathRectangle);    
        
        transitionRect.setInterpolator(Interpolator.LINEAR);  
        transitionRect.setCycleCount(PathTransition.INDEFINITE);                // Sets the number of times the animation should repeat. In our case we set an infinite loop on the animation.
        transitionRect.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); 
        // end rectangle animation


        pane.getChildren().addAll(pathCircle, movingCircle);
        pane.getChildren().addAll(pathRectangle, movingRectangle);

        Button growButton = new Button("Grow");
        growButton.setOnAction(event -> {
            for (Node n : pane.getChildren()) {
                if (n instanceof Circle && n != pathCircle) {
                    Circle c = (Circle) n;
                    double currentRadius = c.getRadius();
                    c.setRadius(currentRadius * 1.1); // Increase radius
                }

                if (n instanceof Rectangle && n != pathRectangle) 
                {
                    Rectangle r = (Rectangle) n;
                    r.setHeight(r.getHeight() * 1.1); // Decrease height
                    r.setWidth(r.getWidth() * 1.1); // Decrease height
                }
            }
        });
        Button shrinkButton = new Button("Shrink");
        shrinkButton.setOnAction(event -> {
            for (Node n : pane.getChildren()) {
                if (n instanceof Circle && n != pathCircle) {
                    Circle c = (Circle) n;
                    double currentRadius = c.getRadius();
                    c.setRadius(currentRadius * 0.9); // Decrease radius
                }

                if (n instanceof Rectangle && n != pathRectangle) 
                {
                    Rectangle r = (Rectangle) n;
                    r.setHeight(r.getHeight() * 0.9); // Decrease height
                    r.setWidth(r.getWidth() * 0.9); // Decrease height
                }
            }
        });

        Button pathVisibilityButton = new Button("Toggle path visibility");
        pathVisibilityButton.setOnAction(event -> {
            if (pathCircle.getOpacity() > 0) {
                pathCircle.setOpacity(0); // Opacity 0 means invisible
                pathRectangle.setOpacity(0);
            } else {
                pathCircle.setOpacity(100);
                pathRectangle.setOpacity(100);
            }
        });

        HBox buttonRow = new HBox(5, growButton, shrinkButton, pathVisibilityButton);
        buttonRow.setAlignment(Pos.BOTTOM_CENTER);
        root.getChildren().addAll(pane, buttonRow);
        VBox.setVgrow(pane, Priority.ALWAYS); // Without this line, pane is empty

        primaryStage.setTitle("Click to Draw Circle");
        primaryStage.setScene(scene);
        primaryStage.show();

        transition.play(); // Start the animation
        transitionRect.play();
    }
}