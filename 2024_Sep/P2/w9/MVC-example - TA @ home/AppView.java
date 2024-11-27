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
    // root node
    private VBox view;

    // other non root nodes
    private TableView<Todo> todoView;
    private Button addTodoBtn;
    private Button updateTodoBtn;
    private Button removeTodoBtn;

    // cotroller and view object references
    private AppController controller;
    private AppModel model;

    // main windows stage object, used for creating main window as well as model windows
    private Stage primaryStage;

    public AppView(AppController controller, AppModel model, Stage primaryStage) 
    {

        // intialize controller and model objects
        this.controller = controller;
        this.model = model;
        this.primaryStage = primaryStage;

        createAndConfigurePane();           // create root node, align it
        createAndLayoutControls();          // crteate and add other non-root nodes to root
        updateControllerFromListeners();    // notify conreoller when view received new input from user
        observeModelAndUpdateControls();    // observe property changes in model and update controls in the view accordingly
    }

    // return root node back to caller
    public Parent asParent() 
    {
        return view;            // return root node
    }

    // Observe the model properties and update nodes in the view if needed
    private void observeModelAndUpdateControls() 
    {
        // Not needed here
    }

    // when user inputs to view, send a notification to controller
    // controller will nofify model
    private void updateControllerFromListeners() 
    {
        // Not needed here
    }

    // create and align other non-root nodes
    private void createAndLayoutControls() 
    {

        // Setup the TableView
        this.todoView = new TableView<>();
        TableColumn<Todo, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setMinWidth(220.0);
        descriptionCol.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());

        TableColumn<Todo, Status> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        TableColumn<Todo, Priority> priorityCol = new TableColumn<>("Priority");
        priorityCol.setCellValueFactory(cellData -> cellData.getValue().priorityProperty());

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

        HBox buttonRow = new HBox(5, addTodoBtn, updateTodoBtn, removeTodoBtn);

        view.getChildren().addAll(this.todoView, buttonRow);
    }

    // create root node
    private void createAndConfigurePane() 
    {
        view = new VBox(5);
        view.setAlignment(Pos.CENTER);
    }

    // creating a model window to add a To Do
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


        // priority        
        RadioButton lowBtn = new RadioButton("Low Priority");
        RadioButton mediumBtn = new RadioButton("Medium Priority");
        RadioButton highBtn = new RadioButton("High Priority");
        ToggleGroup toggleGroupPriority = new ToggleGroup();
        lowBtn.setToggleGroup(toggleGroupPriority);
        mediumBtn.setToggleGroup(toggleGroupPriority);
        highBtn.setToggleGroup(toggleGroupPriority);
        HBox radioBtnPriorityRow = new HBox(5, lowBtn, mediumBtn, highBtn);
        radioBtnPriorityRow.setAlignment(Pos.CENTER);

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
            if (highBtn.isSelected())
                priority = Priority.HIGH;
            else if (mediumBtn.isArmed())
                priority = Priority.MEDIUM;
            else
                priority = Priority.LOW;

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

        VBox root = new VBox(5, descriptionRow, radioBtnRow, radioBtnPriorityRow, buttonRow);
        root.setAlignment(Pos.CENTER);

        Scene helloScene = new Scene(root, 300, 100);

        stage.setScene(helloScene);
        stage.show();
    }

    // creating a model window to edit a To Do
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

        // priority        
        RadioButton lowBtn = new RadioButton("Low Priority");
        RadioButton mediumBtn = new RadioButton("Medium Priority");
        RadioButton highBtn = new RadioButton("High Priority");
        ToggleGroup toggleGroupPriority = new ToggleGroup();
        lowBtn.setToggleGroup(toggleGroupPriority);
        mediumBtn.setToggleGroup(toggleGroupPriority);
        highBtn.setToggleGroup(toggleGroupPriority);
        HBox radioBtnPriorityRow = new HBox(5, lowBtn, mediumBtn, highBtn);
        radioBtnPriorityRow.setAlignment(Pos.CENTER);

        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(event -> {
            String text = descriptionField.getText().trim();
            Status oldStatus = model.todosProperty().get(index).getStatus();
            Priority oldPriority = model.todosProperty().get(index).getPriority();
            Status newStatus;
            if (inProgressBtn.isSelected()) {
                newStatus = Status.IN_PROGRESS;
            } else if (wontCompleteBtn.isSelected()) {
                newStatus = Status.WONT_COMPLETE;
            } else {
                newStatus = Status.DONE;
            }

            Priority priority;
            if (highBtn.isSelected())
                priority = Priority.HIGH;
            else if (mediumBtn.isArmed())
                priority = Priority.MEDIUM;
            else
                priority = Priority.LOW;

            boolean changedStatus = oldStatus != newStatus;
            boolean changedPriority = oldPriority != priority;
            boolean newTextIsNonEmptyAndDiffers = !text.isEmpty() && !text.equals(oldText);
            if (newTextIsNonEmptyAndDiffers || changedStatus || changedStatus) {
                Todo t = new Todo(descriptionField.getText(), newStatus, priority);
                this.controller.updateTodo(t, index);
                stage.close();
            }
        });
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(event -> stage.close());

        HBox buttonRow = new HBox(5, submitBtn, cancelBtn);
        buttonRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(5, descriptionRow, radioBtnRow, radioBtnPriorityRow, buttonRow);
        root.setAlignment(Pos.CENTER);

        Scene helloScene = new Scene(root, 300, 100);

        stage.setScene(helloScene);
        stage.show();
    }
}