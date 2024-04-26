import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MultiWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Count clicks");

        // This button will create a new window.
        Button helloButton = new Button("Say Hello");
        helloButton.setOnAction(event -> createHelloWindow());

        Button helloButton2 = new Button("Say Hello And Close With Main");
        helloButton2.setOnAction(event -> createHelloWindow(primaryStage));

        HBox root = new HBox(10, helloButton,helloButton2);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createHelloWindow() {
        Stage helloStage = new Stage();
        helloStage.setTitle("Hello Window");

        Label helloLabel = new Label("Hello! -  \nDoes not close with main window\n Can open multiple instances");
        helloLabel.setAlignment(Pos.CENTER);

        Scene helloScene = new Scene(helloLabel, 400, 100);

        helloStage.setScene(helloScene);
        helloStage.show();
    }

    private void createHelloWindow(Stage primaryStage) { // Need primaryStage as a parameter
        Stage helloStage = new Stage();
        helloStage.initOwner(primaryStage); // Set `primaryStage` to be the owner of `helloStage`
        helloStage.setTitle("Hello Window");
    
        Label helloLabel = new Label("Hello! - \nThis closes with main window\n Can open multiple instances");
        helloLabel.setAlignment(Pos.CENTER);
    
        Scene helloScene = new Scene(helloLabel, 400, 100);
    
        helloStage.setScene(helloScene);
        helloStage.show();
    }
} 