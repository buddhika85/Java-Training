import java.net.URL;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
        //ArrayList<Image> swirl = getWaterSwirl();     
        ArrayList<Image> swirl = getFlame2();   //  getWaterSwirl();     

        // how many frames we plan to show with in this time line?
        int frameCount = swirl.size();

        // how much time we will show a frame?
        double frameDuration = 0.08;                                    // Duration of each frame in seconds

        // create initial frame
        ImageView swirlView = new ImageView(swirl.get(0));        // set the initial image to swirlView - 0th index
        swirlView.setOpacity(0);                                        // Opacity 0 means invisible

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

        // how many times the time line should show to user - here its once
        timeline.setCycleCount(1);

        // on mouse click of the pane
        pane.setOnMouseClicked(event -> 
        {
            double x = event.getX();
            double y = event.getY();


            // By subtracting half the height from the x-coordinate of the click, 
            // the code ensures that the center of the ImageView aligns with the x-coordinate of the click.
            // lets say x = 50 and
            // swirlViews witdth is 5
            // switViewX = (50 - (5/2)) => 47.5  => so, 2.5 of swirl view on left of x, other 2.5 is on right of x
            swirlView.setX(x - swirlView.getBoundsInParent().getWidth() / 2);     
            swirlView.setY(y - swirlView.getBoundsInParent().getHeight() / 2);

            // 2D graphics visible area is alreays positive
            // swirlView.setX(+50);
            // swirlView.setY(+50);

            swirlView.setOpacity(100);          // Show swirl view
            timeline.stop();                    // Stop the timeline if it's currently running
            timeline.playFromStart();           // Play the animation from the beginning
        });

        pane.getChildren().addAll(background, swirlView);
        return pane;
    }

    ArrayList<Image> getWaterSwirl() 
    {
        ArrayList<Image> images = new ArrayList<>();
        for (int i = 0; i <= 41; i++) {
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


    ArrayList<Image> getFlame2() 
    {
        ArrayList<Image> images = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            String filename;
            String folderPath = "./flame2/";
            if (i < 10) {
                filename = folderPath + "0" + i + ".png";
            } else {
                filename = folderPath + i + ".png";
            }
            URL url = this.getClass().getResource(filename);
            images.add(new Image(
                url.toExternalForm(),       // source of image - toExternalForm(): This method converts the URL to a string that can be used by the Image view
                260.0,                       // width
                260.0,                       // height
                true,                       // preseve aspect ratio (the ratio of width to height) of the image will be maintained when resizing
                true                        // smooth = true -> the image will be scaled using a smoothing algorithm, which helps to reduce the appearance of pixelation and makes the image look better when resized.
                ));
        }
        return images;
    }

    
}