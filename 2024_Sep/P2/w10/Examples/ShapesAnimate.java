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

public class ShapesAnimate extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        VBox root = new VBox(5);

        Pane pane = new Pane();
        int sceneWidth = 400;
        int sceneHeight = 400;
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        Circle movingCircle = new Circle(10);
        movingCircle.setFill(Color.ORANGERED);

        Circle pathCircle = new Circle(70);
        pathCircle.setStroke(javafx.scene.paint.Color.BLACK);
        pathCircle.setFill(null); // Don't fill in the circle with any colour
        pathCircle.setCenterX(sceneWidth / 4);
        pathCircle.setCenterY(sceneHeight / 4);

        PathTransition transition = new PathTransition();
        transition.setNode(movingCircle);                       // set movingCircle object to move/animate  
        transition.setDuration(Duration.seconds(4));            // duration of animation for a full cycle

        // Defines the path that the node will follow during the transition. 
        // Here movingCircle will follow the path set by pathCircle.
        transition.setPath(pathCircle);      


        // Rectangles
        // moving rectangle
        Rectangle movingRectangle = new Rectangle(10, 20);      // w,h
        movingRectangle.setFill(Color.GREENYELLOW);
    
        // path rectangle
        Rectangle pathRectangle = new Rectangle(100, 100);
        pathRectangle.setStroke(javafx.scene.paint.Color.BLACK);
        pathRectangle.setFill(null); 
        // set the position
        pathRectangle.setX((sceneWidth / 5) * 3);
        pathRectangle.setY((sceneHeight / 5) * 3);
    
        // transition
        PathTransition transitionRect = new PathTransition();
        transitionRect.setNode(movingRectangle);                        // set movingRectangle object to move/animate  
        transitionRect.setDuration(Duration.seconds(4));                // duration of animation for a full cycle
        transitionRect.setPath(pathRectangle);   


        

        // Determines the rate of change/feel of the animation. 
        // In our case LINEAR means a constant rate of motion. 
        // Try out the following options: EASE_IN, EASE_OUT, EASE_BOTH.   
        // LINEAR -  The value progresses in a straight line, meaning there’s no acceleration or deceleration; it moves at a steady pace.  
        // EASE_IN - The animation begins slowly and accelerates towards the end, creating a sense of building momentum.
        // EASE_OUT - The EASE_OUT interpolator starts the animation quickly and then slows down towards the end. giving a smooth and gentle finish.
        // EASE_BOTH - Combines above 2.  The animation starts slowly, speeds up in the middle, and then slows down again towards the end. It creates a smooth, natural-looking motion.          
        transition.setInterpolator(Interpolator.LINEAR);  
        transitionRect.setInterpolator(Interpolator.LINEAR);          
        
        // how many cycles of animations, here its inifinit loop, specify an int here and see
        transition.setCycleCount(PathTransition.INDEFINITE);
        transitionRect.setCycleCount(PathTransition.INDEFINITE);
        
        // setting rotation of the moving node
        // node will always align perpendicular (90 degrees to direction of the travel) to the tangent (straight direction line) of the path
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transitionRect.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        // add nodes to pane
        pane.getChildren().addAll(pathCircle, movingCircle, pathRectangle, movingRectangle);

        Button growButton = new Button("Grow");
        growButton.setOnAction(event -> {
            for (Node n : pane.getChildren()) {
                if (n instanceof Circle && n != pathCircle) {
                    Circle c = (Circle) n;
                    double currentRadius = c.getRadius();
                    c.setRadius(currentRadius * 1.1); // Increase radius
                }

                if (n instanceof Rectangle && n != pathRectangle) {
                    Rectangle r = (Rectangle) n;
                    r.setWidth(r.getWidth() * 1.1);
                    r.setHeight(r.getHeight() * 1.1);
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

                if (n instanceof Rectangle && n != pathRectangle) {
                    Rectangle r = (Rectangle) n;
                    r.setWidth(r.getWidth() * 0.9);
                    r.setHeight(r.getHeight() * 0.9);
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