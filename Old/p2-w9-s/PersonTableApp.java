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

public class PersonTableApp extends Application 
{

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Person Table");

        // Define the TableView and its columns
        TableView<PersonEntity> table = new TableView<>();
        TableColumn<PersonEntity, String> firstNameCol = new TableColumn<>("First Name");
        TableColumn<PersonEntity, String> lastNameCol = new TableColumn<>("Last Name");
        TableColumn<PersonEntity, Integer> ageCol = new TableColumn<>("Age");

        // Define how to fill data for each column
        firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        // NOTE: Non-String properties need the call to `.asObject()`.
        ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());

        // Java gives a warning about this line. Don't worry about it.
        table.getColumns().addAll(firstNameCol, lastNameCol, ageCol);

        // Sample data
        ObservableList<PersonEntity> data = FXCollections.observableArrayList(
            new PersonEntity("John", "Doe", 20),
            new PersonEntity("Mike", "Smith", 30),
            new PersonEntity("Jane", "Doe", 18)
        );

        // set obseravble list to be observed by table view
        table.setItems(data);

        // This button will create a new window.
        Button addPersonButton = new Button("Enter info");
        // on add btn press - opern a model window by executing the method 'createAddPersonForm'
        addPersonButton.setOnAction(event -> 
        {
            createAddPersonForm(primaryStage, data);
        });

        Button deletePersonButton = new Button("Delete selected Person");
        // on delete btn press
        deletePersonButton.setOnAction(event -> 
        {
            // get selected index of the ObservableList
            int index = table.getSelectionModel().getSelectedIndex();       
            
            // remove by index
            data.remove(index);
        });


        HBox buttonRow = new HBox(5, addPersonButton, deletePersonButton);

        VBox vbox = new VBox(table, buttonRow);
        Scene scene = new Scene(vbox, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createAddPersonForm(Stage primaryStage, ObservableList<PersonEntity> data) 
    {
        Stage stage = new Stage();
        stage.initOwner(primaryStage);
        stage.initModality(Modality.APPLICATION_MODAL);         // it is a model window

        // Text boxes
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Enter your first name");  // watermark 
        
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Enter your last name");

        // Rows - text boxes added to HBox rows
        HBox firstNameRow = new HBox(5, new Label("First name:"), firstNameField);
        firstNameRow.setAlignment(Pos.CENTER);

        HBox lastNameRow = new HBox(5, new Label("Last name:"), lastNameField);
        lastNameRow.setAlignment(Pos.CENTER);

        // on submit press
        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(event -> 
        {
            data.add(new PersonEntity(firstNameField.getText(), lastNameField.getText(), 66));
            stage.close();
        });

        // on cancel press
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