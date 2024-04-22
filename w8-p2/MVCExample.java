import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVCExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MVC: sum");
        ArithmeticModel model = new ArithmeticModel();
        ArithmeticController controller = new ArithmeticController(model);
        ArithmeticView view = new ArithmeticView(controller, model);

        Scene scene = new Scene(view.asParent(), 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}