import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Second extends Application {
    public static void main(String[] args) {
        Second.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Multiple buttons");

        Label label = new Label("Here's a range of buttons");

        // If we already know the text that a button should be labelled with,
        // we can just use following alternate constructor instead of calling
        // the `setText` method.
        Button smallBtn = new Button("Small");
        Button mediumBtn = new Button("Medium");
        Button largeBtn = new Button("Large");

        // This variable represents a row of buttons: Small, Medium and Large.
        HBox sizes = new HBox(smallBtn, mediumBtn, largeBtn);
        sizes.setAlignment(Pos.CENTER);

        Button morningBtn = new Button("Morning");
        Button afternoonBtn = new Button("Afternoon");
        Button nightBtn = new Button("Night");

        // This variable represents a row of buttons: Morning, Afternoon and
        // Night.
        HBox times = new HBox(morningBtn, afternoonBtn, nightBtn);
        times.setAlignment(Pos.CENTER);

        // Similarly we set the children nodes of a VBox directly in its
        // constructor.
        VBox root = new VBox(label, sizes, times);

        root.setAlignment(Pos.CENTER);

        // Scene is defined here with the VBox as the root node, a width of
        // 300 pixels and height of 250 pixels.
        Scene scene = new Scene(root, 300, 250);

        // Set the scene within the primary stage
        primaryStage.setScene(scene);

        // Display the stage (window)
        primaryStage.show();
    }
}