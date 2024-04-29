import javax.swing.event.ChangeListener;

import javafx.collections.ListChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AppView 
{
    // root
    private VBox view;                         
    private TableView<Todo> todoView;
    private Button addTodoBtn;
    private Button updateTodoBtn;
    private Button removeTodoBtn;
    private Button removeAllTodoBtn;
    private Button removeAllDoneTodoBtn;

    private AppController controller;
    private AppModel model;
    private Stage primaryStage;

    public AppView(AppController controller, AppModel model, Stage primaryStage) 
    {

        this.controller = controller;
        this.model = model;
        this.primaryStage = primaryStage;

        createAndConfigurePane();           // create main container - root node
        createAndLayoutControls();          // create child nodes of root
        updateControllerFromListeners();    // add property change Liteners to the view, call contraoller methods --> controller will update model
        observeModelAndUpdateControls();    // observe changes in the model properties and update view controls if needed
    }

    public Parent asParent() 
    {
        return view;
    }

    private void observeModelAndUpdateControls() 
    {
        // Not needed here
        model.todosProperty().addListener((ListChangeListener<? super Todo>) change -> {
            //if (change.was)
        });
    }

    private void updateControllerFromListeners() 
    {
        // Not needed here
    }

    // create child nodes of root
    private void createAndLayoutControls() 
    {
        // Setup the TableView
        this.todoView = new TableView<>();
        // descriotion column
        TableColumn<Todo, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setMinWidth(220.0);
        descriptionCol.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());

        // status column
        TableColumn<Todo, Status> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // priority column
        TableColumn<Todo, Priority> priorityCol = new TableColumn<>("Priority");
        priorityCol.setCellValueFactory(cellData -> cellData.getValue().priorityProperty());

        // add columns to table
        this.todoView.getColumns().addAll(descriptionCol, statusCol, priorityCol);
        this.todoView.setItems(model.todosProperty());

        // Setup the buttons
        this.addTodoBtn = new Button("Add To-do");
        this.addTodoBtn.setOnAction(event -> createAddTodoForm());

        this.updateTodoBtn = new Button("Edit to-do");
        this.updateTodoBtn.setOnAction(event -> {
            int index = this.todoView.getSelectionModel().getSelectedIndex();
            if (index != -1) {
                createUpdateTodoForm(index);
            }

        });

        this.removeTodoBtn = new Button("Remove To-do");
        removeTodoBtn.setOnAction(event -> {
            int index = this.todoView.getSelectionModel().getSelectedIndex();
            if (index != -1) {
                this.controller.removeTodo(index);
            }
        });

        removeAllTodoBtn = new Button("Remove All To-dos");
        removeAllTodoBtn.setOnAction(event -> {
            controller.removeAll();
        });

        removeAllDoneTodoBtn = new Button("Remove All done To-dos");
        removeAllDoneTodoBtn.setOnAction(event -> {
            controller.removeAllDone();
        });

        HBox buttonRow = new HBox(5, addTodoBtn, updateTodoBtn, 
            removeTodoBtn, removeAllTodoBtn, removeAllDoneTodoBtn);

        view.getChildren().addAll(this.todoView, buttonRow);
    }

    // create main container - root node
    private void createAndConfigurePane() 
    {
        view = new VBox(5);
        view.setAlignment(Pos.CENTER);
    }

    private void createAddTodoForm() 
    {
        Stage stage = new Stage();
        stage.initOwner(primaryStage);
        stage.initModality(Modality.APPLICATION_MODAL);

        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Enter to-do description");
        HBox descriptionRow = new HBox(5, new Label("Description:"), descriptionField);
        descriptionRow.setAlignment(Pos.CENTER);

        // Toggle group to set status
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton inProgressBtn = new RadioButton("In progress");
        inProgressBtn.setToggleGroup(toggleGroup);

        RadioButton wontCompleteBtn = new RadioButton("Won't complete");
        wontCompleteBtn.setToggleGroup(toggleGroup);

        RadioButton doneBtn = new RadioButton("Done");
        doneBtn.setToggleGroup(toggleGroup);

        HBox radioBtnRow = new HBox(5, inProgressBtn, doneBtn, wontCompleteBtn);
        radioBtnRow.setAlignment(Pos.CENTER);


        // Toggle group to set priority
        ToggleGroup toggleGroupStatus = new ToggleGroup();
        RadioButton lowRdBtn = new RadioButton("Low");
        lowRdBtn.setToggleGroup(toggleGroupStatus);
        RadioButton mediumRdBtn = new RadioButton("Medium");
        mediumRdBtn.setToggleGroup(toggleGroupStatus);
        RadioButton highRdBtn = new RadioButton("High");
        highRdBtn.setToggleGroup(toggleGroupStatus);
        HBox priorityRadioBtnRow = new HBox(5, lowRdBtn, mediumRdBtn, highRdBtn);
        priorityRadioBtnRow.setAlignment(Pos.CENTER);

        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(event -> {
            String text = descriptionField.getText().trim();
            Status status;
            if (inProgressBtn.isSelected()) {
                status = Status.IN_PROGRESS;
            } else if (wontCompleteBtn.isSelected()) {
                status = Status.WONT_COMPLETE;
            } else {
                status = Status.DONE;
            }

            Priority priority;
            if (lowRdBtn.isSelected())
            {
                priority = Priority.LOW;
            }
            else if (mediumRdBtn.isSelected())
            {
                priority = Priority.MEDIUM;
            }
            else
            {
                priority = Priority.HIGH;
            }


            if (!text.isEmpty()) {
                Todo t = new Todo(descriptionField.getText(), status, priority);
                this.controller.addTodo(t);
                stage.close();
            }
        });
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(event -> stage.close());

        HBox buttonRow = new HBox(5, submitBtn, cancelBtn);
        buttonRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(5, descriptionRow, radioBtnRow, priorityRadioBtnRow, buttonRow);
        root.setAlignment(Pos.CENTER);

        Scene helloScene = new Scene(root, 300, 150);

        stage.setScene(helloScene);
        stage.show();
    }

    private void createUpdateTodoForm(int index) 
    {
        Stage stage = new Stage();
        stage.initOwner(primaryStage);
        stage.initModality(Modality.APPLICATION_MODAL);

        // We access the model's todosProperty to determine the description of the
        // selected to-do.
        TextField descriptionField = new TextField();
        String oldText = model.todosProperty().get(index).getDescription();
        descriptionField.setPromptText("Enter new description");
        descriptionField.setText(oldText);

        HBox descriptionRow = new HBox(5, new Label("Description:"), descriptionField);
        descriptionRow.setAlignment(Pos.CENTER);

        // Toggle group to set status
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton inProgressBtn = new RadioButton("In progress");
        inProgressBtn.setToggleGroup(toggleGroup);

        RadioButton wontCompleteBtn = new RadioButton("Won't complete");
        wontCompleteBtn.setToggleGroup(toggleGroup);

        RadioButton doneBtn = new RadioButton("Done");
        doneBtn.setToggleGroup(toggleGroup);

        HBox radioBtnRow = new HBox(5, inProgressBtn, doneBtn, wontCompleteBtn);
        radioBtnRow.setAlignment(Pos.CENTER);


        // Toggle group to set priority
        ToggleGroup toggleGroupStatus = new ToggleGroup();
        RadioButton lowRdBtn = new RadioButton("Low");
        lowRdBtn.setToggleGroup(toggleGroupStatus);
        RadioButton mediumRdBtn = new RadioButton("Medium");
        mediumRdBtn.setToggleGroup(toggleGroupStatus);
        RadioButton highRdBtn = new RadioButton("High");
        highRdBtn.setToggleGroup(toggleGroupStatus);
        HBox priorityRadioBtnRow = new HBox(5, lowRdBtn, mediumRdBtn, highRdBtn);
        priorityRadioBtnRow.setAlignment(Pos.CENTER);

        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(event -> {
            String text = descriptionField.getText().trim();
            Status oldStatus = model.todosProperty().get(index).getStatus();
            Status newStatus;
            if (inProgressBtn.isSelected()) {
                newStatus = Status.IN_PROGRESS;
            } else if (wontCompleteBtn.isSelected()) {
                newStatus = Status.WONT_COMPLETE;
            } else {
                newStatus = Status.DONE;
            }

            Priority newPriority;
            if (lowRdBtn.isSelected()) {
                newPriority = Priority.LOW;
            } else if (mediumRdBtn.isSelected()) {
                newPriority = Priority.MEDIUM;
            } else {
                newPriority = Priority.HIGH;
            }

            boolean changedStatus = oldStatus != newStatus;
            boolean newTextIsNonEmptyAndDiffers = !text.isEmpty() && !text.equals(oldText);
            if (newTextIsNonEmptyAndDiffers || changedStatus) {
                Todo t = new Todo(descriptionField.getText(), newStatus, newPriority);
                this.controller.updateTodo(t, index);
                stage.close();
            }
        });
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(event -> stage.close());

        HBox buttonRow = new HBox(5, submitBtn, cancelBtn);
        buttonRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(5, descriptionRow, radioBtnRow, priorityRadioBtnRow, buttonRow);
        root.setAlignment(Pos.CENTER);

        Scene helloScene = new Scene(root, 300, 150);

        stage.setScene(helloScene);
        stage.show();
    }
}