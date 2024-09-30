import java.net.URL;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GraphicsExample extends Application 
{

    private static final int STAGE_WIDTH = 960;
    private static final int STAGE_HEIGHT = 540;

    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setScene(new Scene(createContent(), STAGE_WIDTH, STAGE_HEIGHT));
        primaryStage.show();
    }

    private Region createContent() 
    {
        // container for graphics with more precise positioning
        Pane pane = new Pane();

        // A ImageView is a node used to display images in JavaFX.
        // gets URL of the background.png file. The getResource() method locates the image within the same folder as the class.
        // toExternalForm(): Converts the URL returned by getResource() to a string that can be used by the ImageView to load the image.
        ImageView background = new ImageView(this.getClass().getResource("background.png").toExternalForm());


        // maintain apect ratio of the image
        // This means the image won't be distorted (pulled/twisted) when its width or height changes—it will scale proportionally.
        background.setPreserveRatio(true);

        // ImageView's height will automatically adjust to match the height/width of the Pane whenever the Pane is resized. 
        background.fitHeightProperty().bind(pane.heightProperty());
        background.fitWidthProperty().bind(pane.widthProperty());


                        

        // Timeline: contains a collection a keyframes that gets displayed over a periods of time
        // Keyframe: is an object which contains a node (an imageView) and how much that it needs to be displayed
        Timeline timeline = new Timeline();

        // gets a list of image obejcts
        // will be used to create key frames content - each image will be stored in a key frame
        ArrayList<Image> swirl = getWaterSwirl();     

        // how many frames we plan to show with in this time line?
        int frameCount = swirl.size();

        // how much time we will show a frame?
        double frameDuration = 0.02;                                    // Duration of each frame in seconds

        // create initial frame
        ImageView[] swirlViews = new ImageView[4];        
        for (int i = 0; i < swirlViews.length; i++) 
        {
            swirlViews[i] = new ImageView(swirl.get(0));                    // set the initial image to swirlView - 0th index
            swirlViews[i].setOpacity(0);                                        // Opacity 0 means invisible
        }
        

        for (ImageView swirlView : swirlViews) 
        {
            for (int i = 0; i < frameCount; i++) 
            {
                // get image by index
                final Image image = swirl.get(i);

                // display above image for specfic duration using a KeyFrame object
                KeyFrame frame = new KeyFrame(Duration.seconds(i * frameDuration), e -> 
                {
                    swirlView.setImage(image);
                });

                // add the keyframe to timeline
                timeline.getKeyFrames().add(frame);
            }
        }

        // how many times the time line should show to user - here its once
        timeline.setCycleCount(1);



        pane.setOnMouseClicked(event -> 
        {
            for (int i = 0; i < swirlViews.length; i++) 
            {
                ImageView swirlView = swirlViews[i];
                int xTo = 250, yTo = 250;
                if (i == 1)
                {
                    xTo = -250;
                    yTo = -250;
                }
                else if (i == 2)
                {
                    xTo = 250;
                    yTo = -250;
                }
                else if (i == 3)
                {
                    xTo = -250;
                    yTo = 250;
                }

                TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), swirlView);
                translateTransition.setCycleCount(1);
                
                double x = event.getSceneX();
                double y = event.getSceneY();
                translateTransition.setFromX(x - swirlView.getBoundsInParent().getWidth() /
                        2);
                translateTransition.setFromY(y - swirlView.getBoundsInParent().getHeight() /
                        2);
                translateTransition.setToX(x + xTo);
                translateTransition.setToY(y + yTo);

                swirlView.setOpacity(100);
                timeline.stop(); // Stop the timeline if it's currently running
                timeline.playFromStart(); // Play the animation from the beginning
                translateTransition.playFromStart();
            }
        });

        pane.getChildren().addAll(background, swirlViews[0], swirlViews[1], swirlViews[2], swirlViews[3]);
        return pane;
    }

    ArrayList<Image> getWaterSwirl() 
    {
        ArrayList<Image> images = new ArrayList<>();
        for (int i = 0; i < 41; i++) {
            String filename;
            String folderPath = "./water_swirl/";
            if (i < 10) {
                filename = folderPath + "water9000" + i + ".png";
            } else {
                filename = folderPath + "water900" + i + ".png";
            }
            URL url = this.getClass().getResource(filename);
            images.add(new Image(
                url.toExternalForm(),       // source of image - toExternalForm(): This method converts the URL to a string that can be used by the Image view
                60.0,                       // width
                60.0,                       // height
                true,                       // preseve aspect ratio (the ratio of width to height) of the image will be maintained when resizing
                true                        // smooth = true -> the image will be scaled using a smoothing algorithm, which helps to reduce the appearance of pixelation and makes the image look better when resized.
                ));
        }
        return images;
    }

    
}