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
    // root node of main window
    private VBox view;

    // other non root nodes of main window - which needs global access with in class
    private TableView<Todo> todoView;
    private Button addTodoBtn;
    private Button updateTodoBtn;
    private Button removeTodoBtn;
    private Button removeAllTodosBtn;
    private Button removeAllDoneTodosBtn;

    // cotroller and view object references
    private AppController controller;
    private AppModel model;

    // stage of the main window - used to set owner of the model window stages
    private Stage primaryStage;

    public AppView(AppController controller, AppModel model, Stage primaryStage) 
    {
        // intialize controller and model objects
        this.controller = controller;
        this.model = model;

        // intialize stage - coming from Driver class
        this.primaryStage = primaryStage;

        createAndConfigurePane();           // create root node, align it
        createAndLayoutControls();          // crteate and add other non-root nodes to root
        updateControllerFromListeners();    // notify conreoller when view received new input from user
        observeModelAndUpdateControls();    // observe property changes in model and update controls in the view accordingly
    }

    // return root node back to caller
    public Parent asParent() 
    {
        return view;
    }

    // Observe the model properties and update nodes in the view if needed
    private void observeModelAndUpdateControls() 
    {
        // Not needed here
        // we will have this only if we had singular nodes which observes properties of the model
        // here we have a table view and Observable list that is bound to the table autmatically does this part
    }

    // when user inputs to view, send a notification to controller
    // controller will nofify model
    private void updateControllerFromListeners() 
    {
        // Not needed here - no inputs taken from this view
    }

    // create and align other non-root nodes of main window
    private void createAndLayoutControls() 
    {

        // Setup the TableView
        this.todoView = new TableView<>();

        // create column objects
        TableColumn<Todo, String> descriptionCol = new TableColumn<>("Description");
        TableColumn<Todo, Status> statusCol = new TableColumn<>("Status");
        TableColumn<Todo, Priority> priorityCol = new TableColumn<>("Priority");

        // give instructions on how to populate each column - which property to bind 
        statusCol.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        descriptionCol.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        priorityCol.setCellValueFactory(cellData -> cellData.getValue().priorityProperty());

        // width
        descriptionCol.setMinWidth(220.0);
        
        // add all column objects to TableView
        this.todoView.getColumns().addAll(descriptionCol, statusCol, priorityCol);

        // bind table with models - ObservableList<Todo> todos
        this.todoView.setItems(model.todosProperty());

        // Setup the buttons
        this.addTodoBtn = new Button("Add To-do");
        this.addTodoBtn.setOnAction(event -> 
        {
            // show Add From
            createAddTodoForm();
        });

        this.updateTodoBtn = new Button("Edit to-do");
        this.updateTodoBtn.setOnAction(event -> 
        {
            // get selected index from table view 
            // this will be -1 if user did not select any row on the table view
            int index = this.todoView.getSelectionModel().getSelectedIndex();

            // if user selected a row
            if (index != -1) 
            {
                // show Update Form
                createUpdateTodoForm(index);
            }

        });

        this.removeTodoBtn = new Button("Remove To-do");
        removeTodoBtn.setOnAction(event -> 
        {
            // get selected index from table view 
            // this will be -1 if user did not select any row on the table view
            int index = this.todoView.getSelectionModel().getSelectedIndex();

            if (index != -1) 
            {
                // ask controller to tell model to remove element by given index
                this.controller.removeTodo(index);
            }
        });

        this.removeAllTodosBtn = new Button("Remove all To-dos");
        removeAllTodosBtn.setOnAction(event -> 
        {            
            // ask controller to tell model to remove all
            this.controller.removeAll();            
        });

        this.removeAllDoneTodosBtn = new Button("Remove all Done To-dos");
        removeAllDoneTodosBtn.setOnAction(event -> 
        {            
            // ask controller to tell model to remove all
            this.controller.removeDoneTodos();            
        });

        HBox buttonRow = new HBox(5, addTodoBtn, updateTodoBtn, removeTodoBtn, removeAllTodosBtn, removeAllDoneTodosBtn);

        view.getChildren().addAll(this.todoView, buttonRow);
    }

    // create root node
    private void createAndConfigurePane() 
    {
        view = new VBox(5);
        view.setAlignment(Pos.CENTER);
    }

    private void createAddTodoForm() 
    {
        Stage stage = new Stage();
        stage.initOwner(primaryStage);              // close with main window
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
        ToggleGroup toggleGroupPriority = new ToggleGroup();

        RadioButton lowBtn = new RadioButton("Low");
        lowBtn.setToggleGroup(toggleGroupPriority);

        RadioButton mediumBtn = new RadioButton("Medium");
        mediumBtn.setToggleGroup(toggleGroupPriority);

        RadioButton highBtn = new RadioButton("High");
        highBtn.setToggleGroup(toggleGroupPriority);

        HBox priorityRadioBtnRow = new HBox(5, lowBtn, mediumBtn, highBtn);
        priorityRadioBtnRow.setAlignment(Pos.CENTER);


        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(event -> 
        {
            String text = descriptionField.getText().trim();
            Status status;
            Priority priority;
            if (inProgressBtn.isSelected()) 
            {
                status = Status.IN_PROGRESS;
            } 
            else if (wontCompleteBtn.isSelected()) 
            {
                status = Status.WONT_COMPLETE;
            } 
            else 
            {
                status = Status.DONE;
            }

            if (lowBtn.isSelected()) 
            {
                priority = Priority.LOW;
            } 
            else if (mediumBtn.isSelected()) 
            {
                priority = Priority.MEDIUM;
            } 
            else 
            {
                priority = Priority.HIGH;
            }

            if (!text.isEmpty()) 
            {
                Todo t = new Todo(descriptionField.getText(), status, priority);
                // ask controller to tell model to add this new toDo object
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
        ToggleGroup toggleGroupPriority = new ToggleGroup();

        RadioButton lowBtn = new RadioButton("Low");
        lowBtn.setToggleGroup(toggleGroupPriority);

        RadioButton mediumBtn = new RadioButton("Medium");
        mediumBtn.setToggleGroup(toggleGroupPriority);

        RadioButton highBtn = new RadioButton("High");
        highBtn.setToggleGroup(toggleGroupPriority);

        HBox priorityRadioBtnRow = new HBox(5, lowBtn, mediumBtn, highBtn);
        priorityRadioBtnRow.setAlignment(Pos.CENTER);


        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(event -> 
        {
            String text = descriptionField.getText().trim();
            Status oldStatus = model.todosProperty().get(index).getStatus();
            Priority oldPriority = model.todosProperty().get(index).getPriority();

            Status newStatus;
            if (inProgressBtn.isSelected()) 
            {
                newStatus = Status.IN_PROGRESS;
            } 
            else if (wontCompleteBtn.isSelected()) 
            {
                newStatus = Status.WONT_COMPLETE;
            } 
            else 
            {
                newStatus = Status.DONE;
            }

            Priority priority;
            if (lowBtn.isSelected()) 
            {
                priority = Priority.LOW;
            } 
            else if (mediumBtn.isSelected()) 
            {
                priority = Priority.MEDIUM;
            } 
            else 
            {
                priority = Priority.HIGH;
            }

            boolean changedStatus = oldStatus != newStatus;
            boolean changedPriority = oldPriority != priority;
            boolean newTextIsNonEmptyAndDiffers = !text.isEmpty() && !text.equals(oldText);

            // if any change
            if (newTextIsNonEmptyAndDiffers || changedStatus || changedPriority) 
            {
                Todo t = new Todo(descriptionField.getText(), newStatus, priority);

                // ask controller to tell model to update list index with this new todo object
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
