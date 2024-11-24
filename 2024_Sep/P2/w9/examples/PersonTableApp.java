import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PersonTableApp extends Application {

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Person Table");

        // Define the TableView and its columns
        TableView<PersonModel> table = new TableView<>();
        TableColumn<PersonModel, String> firstNameCol = new TableColumn<>("First Name");
        TableColumn<PersonModel, String> lastNameCol = new TableColumn<>("Last Name");
        TableColumn<PersonModel, Integer> ageCol = new TableColumn<>("Age");

        // Define how to fill data for each column
        firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        // NOTE: Non-String properties need the call to `.asObject()`.
        ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());

        // Java gives a warning about this line. Don't worry about it.
        table.getColumns().addAll(firstNameCol, lastNameCol, ageCol);

        // Sample data
        ObservableList<PersonModel> data = FXCollections.observableArrayList(
                new PersonModel("John", "Doe", 20),
                new PersonModel("Mike", "Smith", 30),
                new PersonModel("Jane", "Doe", 18));

        table.setItems(data);

        // This button will create a new window.
        Button addPersonButton = new Button("Enter info");
        addPersonButton.setOnAction(event -> createAddPersonForm(primaryStage, data));

        Button deletePersonButton = new Button("Delete selected Person");
        deletePersonButton.setOnAction(event -> {
            int index = table.getSelectionModel().getSelectedIndex();
            data.remove(index);
        });
        HBox buttonRow = new HBox(5, addPersonButton, deletePersonButton);

        VBox vbox = new VBox(table, buttonRow);
        Scene scene = new Scene(vbox, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createAddPersonForm(Stage primaryStage, ObservableList<PersonModel> data) 
    {
        Stage stage = new Stage();
        stage.initOwner(primaryStage);
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
            data.add(new PersonModel(firstNameField.getText(), lastNameField.getText(), 66));
            stage.close();
        });
        Button cancelBtn = new Button("Cancel");
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