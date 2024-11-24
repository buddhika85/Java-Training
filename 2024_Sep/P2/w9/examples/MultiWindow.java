import javafx.application.Application;
import javafx.stage.Modality;
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

        Button helloButton2 = new Button("Say Hello - Model Window");
        helloButton2.setOnAction(event -> createHelloWindow(primaryStage));

        HBox root = new HBox(10, helloButton, helloButton2);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // issues
    // 	Can open many new sub windows – often we only want to allow only one instance of the sub window to be opened
    // 	When the sub window is opened you can still interact with the primary window – often we need to make our primary window disabled while sub window is opened
    // 	After closing the primary window – sub windows still remains alive – often we want all sub windows to close when primary window is closed.

    private void createHelloWindow() 
    {
        // 1 Create a new Stage object 
        Stage helloStage = new Stage();
        helloStage.setTitle("Hello Window");

        // 2 Assemble the scene graph for this window         
        Label helloLabel = new Label("Hello!");
        helloLabel.setAlignment(Pos.CENTER);

        // and attach the root node to a new Scene object.
        Scene helloScene = new Scene(helloLabel, 200, 100);

        // 3 Attach the Scene object to the Stage 
        helloStage.setScene(helloScene);

        // 4 Make the window visible by calling show() on the Stage object.
        helloStage.show();
    }

    // using model window 
    private void createHelloWindow(Stage primaryStage) // Need primaryStage as a parameter
    { 
        Stage helloStage = new Stage();
        helloStage.initModality(Modality.APPLICATION_MODAL);        // Model window - only one model window opens and you can interact only with the model window
        //helloStage.initOwner(primaryStage);                         // Set `primaryStage` to be the owner of `helloStage`, when primary windows closes, model window autmatically closes
        helloStage.setTitle("Hello Window");                        
    
        Label helloLabel = new Label("Hello!");
        helloLabel.setAlignment(Pos.CENTER);
    
        Scene helloScene = new Scene(helloLabel, 200, 100);
    
        helloStage.setScene(helloScene);
        helloStage.show();
    }
}