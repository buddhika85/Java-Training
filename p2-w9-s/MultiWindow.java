import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MultiWindow extends Application {

    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Count clicks");

        // This button will create a new window.
        Button helloButton = new Button("Say Hello");
        helloButton.setOnAction(event -> {
            //createHelloWindow();
            //createHelloWindow(primaryStage);              // close with main
            createHelloModelWindow();                       // close with main, disables main, only one modal window opens
        });

        HBox root = new HBox(10, helloButton);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createHelloWindow() 
    {
        Stage helloStage = new Stage();
        helloStage.setTitle("Hello Window");

        Label helloLabel = new Label("Hello!");
        helloLabel.setAlignment(Pos.CENTER);

        Scene helloScene = new Scene(helloLabel, 200, 100);

        helloStage.setScene(helloScene);
        helloStage.show();
    }


    private void createHelloWindow(Stage primaryStage)  // Need primaryStage as a parameter
    {    
        Stage helloStage = new Stage();

        helloStage.initOwner(primaryStage); // Set `primaryStage` to be the owner of `helloStage`

        helloStage.setTitle("Hello Window");
    
        Label helloLabel = new Label("Hello!");
        helloLabel.setAlignment(Pos.CENTER);
    
        Scene helloScene = new Scene(helloLabel, 200, 100);
    
        helloStage.setScene(helloScene);
        helloStage.show();
    }


    private void createHelloModelWindow()  
    {    
        Stage helloStage = new Stage();

        helloStage.initModality(Modality.APPLICATION_MODAL);        // It is a Modal window
        
        helloStage.setTitle("Hello Window");
    
        Label helloLabel = new Label("Hello!");
        helloLabel.setAlignment(Pos.CENTER);
    
        Scene helloScene = new Scene(helloLabel, 200, 100);
    
        helloStage.setScene(helloScene);
        helloStage.show();
    }
    
} 