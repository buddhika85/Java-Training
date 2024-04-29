import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PersonListAddRemove extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Person List");

        ListView<Person> listView = new ListView<>();

        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("John", "Doe", 30),
                new Person("Jane", "Doe", 25),
                new Person("Mike", "Smith", 40));

        listView.setItems(data);

        // This button will create a form within a new window.
        Button addPersonButton = new Button("Add Person");
        addPersonButton.setOnAction(event -> createAddPersonForm(primaryStage, data));

        Button deletePersonButton = new Button("Delete selected Person");
        deletePersonButton.setOnAction(event -> {
            int index = listView.getSelectionModel().getSelectedIndex();        // get the index to remove
            data.remove(index);                                                 // remove by index
        });
        HBox buttonRow = new HBox(5, addPersonButton, deletePersonButton);

        VBox vbox = new VBox(listView, buttonRow);
        Scene scene = new Scene(vbox, 400, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createAddPersonForm(Stage primaryStage, ObservableList<Person> data) {
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
            Person person = new Person(firstNameField.getText(), lastNameField.getText(), 66);

            data.add(person);
            // Close the form
            stage.close();
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