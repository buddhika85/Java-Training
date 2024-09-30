import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SnackStoreDriver  extends Application 
{

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Snack Store");
        SnackStoreModel model = new SnackStoreModel();
        SnackStoreController controller = new SnackStoreController(model);
        SnackStoreView view = new SnackStoreView(controller, model);

        Scene scene = new Scene(view.asParent(), 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}