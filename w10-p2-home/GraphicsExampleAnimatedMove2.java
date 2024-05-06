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

public class GraphicsExampleAnimatedMove2 extends Application 
{

    private static final int STAGE_WIDTH = 960;
    private static final int STAGE_HEIGHT = 540;

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setScene(new Scene(createContent(), STAGE_WIDTH, STAGE_HEIGHT));
        primaryStage.show();
    }

    private Region createContent() 
    {
        Pane pane = new Pane();
        ImageView background = new ImageView(this.getClass().getResource("background.png").toExternalForm());       // construct a URL for image and pass it
        background.setPreserveRatio(true);
        background.fitHeightProperty().bind(pane.heightProperty());             // set the height of Image View to height of Pane
        background.fitWidthProperty().bind(pane.widthProperty());               // set the width of Image View to height of Pane

         // All sprites are loaded into this ArrayList
        ArrayList<Image> swirl = getWaterSwirl();                               // returns an array list of Image objects read from 'water_swirl' folder of the projects root folder

        // The animation is performed by a Timeline object.
        Timeline timeline = new Timeline();                                     // is a collection of key frames, key frame is an object which shows an image a specific amount of time 
        int frameCount = swirl.size();                                          // number of frames = number of images in 'water_swirl' folder
        double frameDuration = 0.02;                                            // Duration of each frame (to show in the window) in seconds       

        // To display these images on screen, we must create ImageView objects. The
        // following ImageView is set to the first image in the above ArrayList.
        ImageView[] swirlViews = {new ImageView(swirl.get(0)), new ImageView(swirl.get(0)), new ImageView(swirl.get(0)), new ImageView(swirl.get(0)) };

        // We set the animated sprite to initially be invisible.
        for (ImageView swirlView : swirlViews) {
            swirlView.setOpacity(0);                                                // transparency level of an element - 0 ==> invisible, 100 ==> fully visible 
        }

        for (int i = 0; i < frameCount; i++) {
            final Image image = swirl.get(i);
            KeyFrame frame = 
                new KeyFrame(Duration.seconds(i * frameDuration), 
                e -> {
                    for (ImageView swirlView : swirlViews) {
                        swirlView.setImage(image);
                    }
                });                                //  creating a key frame - indicating how much time to show, and which image should be included in the frame?
            timeline.getKeyFrames().add(frame);                                 // adding keyframe to timeline
        }

        timeline.setCycleCount(1);                                              // how many repeats for the time line, change this to 5 and see it runs 5 times


        pane.setOnMouseClicked(event -> {
            for (int i = 0; i < swirlViews.length; i++) 
            {
                ImageView swirlView = swirlViews[i];
                TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), swirlView);
                translateTransition.setCycleCount(1);
                
                double x = event.getSceneX();
                double y = event.getSceneY();
                translateTransition.setFromX(x);
                translateTransition.setFromY(y);
                if (i == 0)
                {
                    // down right
                    translateTransition.setToX(x + 250);
                    translateTransition.setToY(y + 250);
                }
                else if (i == 1)
                {
                    // down left
                    translateTransition.setToX(x - 250);
                    translateTransition.setToY(y + 250);
                }
                else if (i == 2)
                {
                    // up right
                    translateTransition.setToX(x + 250);
                    translateTransition.setToY(y - 250);
                }
                else if (i == 3)
                {
                    // up left
                    translateTransition.setToX(x - 250);
                    translateTransition.setToY(y - 250);
                }

                swirlView.setOpacity(100);
                timeline.stop(); // Stop the timeline if it's currently running
                timeline.playFromStart(); // Play the animation from the beginning
                translateTransition.playFromStart();
            }
        });

        pane.getChildren().addAll(background, swirlViews[0], swirlViews[1], swirlViews[2], swirlViews[3]);
        return pane;
    }

    // returns an array list of Image objects read from 'water_swirl' folder of the projects root folder    
    // This method loads all the sprites (PNG file format) in the water_swirl/
    // directory as an ArrayList of Image objects.
    ArrayList<Image> getWaterSwirl() 
    {
        ArrayList<Image> images = new ArrayList<>();
        for (int i = 0; i < 41; i++)                        // 0 to 40
        {
            String filename;
            String folderPath = "./water_swirl/";
            if (i < 10) 
            {
                filename = folderPath + "water9000" + i + ".png";
            } 
            else 
            {
                filename = folderPath + "water900" + i + ".png";
            }
            URL url = this.getClass().getResource(filename);
            images.add(new Image(url.toExternalForm(), 60.0, 60.0, true, true));
        }
        return images;
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
