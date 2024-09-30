import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PersonForm extends Application {

    boolean isPersoninitialised;
    Person person;
    Label personDetails;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Person Form");

        // Note: we set person attribute null at this point.
        this.isPersoninitialised = false;
        this.person = null;

        personDetails = new Label("No person has been set");
        Button setPersonBtn = new Button("Set person");

        setPersonBtn.setOnAction(event -> createForm(primaryStage));

        VBox root = new VBox(5, personDetails, setPersonBtn);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createForm(Stage primaryStage) {
        Stage stage = new Stage();
        stage.initOwner(primaryStage);

        // Make it modal
        stage.initModality(Modality.APPLICATION_MODAL);

        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Enter your first name");
        HBox firstNameRow = new HBox(5, new Label("First name:"), firstNameField);
        firstNameRow.setAlignment(Pos.CENTER);

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Enter your last name");
        HBox lastNameRow = new HBox(5, new Label("Last name:"), lastNameField);
        lastNameRow.setAlignment(Pos.CENTER);

        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(event -> {
            if (!this.isPersoninitialised) {
                this.person = new Person(firstNameField.getText(), lastNameField.getText(), 66);
                this.personDetails.setText(this.person.toString());

                // Close the form
                stage.close();
            }
        });

        Button cancelBtn = new Button("Cancel");

        // If user clicks cancel, we also close the form.
        cancelBtn.setOnAction(event -> stage.close());

        HBox buttonRow = new HBox(5, submitBtn, cancelBtn);
        buttonRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(5, firstNameRow, lastNameRow, buttonRow);
        root.setAlignment(Pos.CENTER);

        Scene helloScene = new Scene(root, 300, 100);

        stage.setScene(helloScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}