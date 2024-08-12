import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVCExample extends Application 
{

    @Override
    public void start(Stage primaryStage) 
    {
        // title of window
        primaryStage.setTitle("My TODO app");                       

        // model, controller and view objects
        AppModel model = new AppModel();
        AppController controller = new AppController(model);
        AppView view = new AppView(controller, model, primaryStage);

        // scene - create it using root node of view, width, height
        Scene scene = new Scene(view.asParent(), 600, 300);

        // attach scene to stage / window
        primaryStage.setScene(scene);

        // show window in the screen
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}