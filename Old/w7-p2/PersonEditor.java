import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PersonEditor extends Application {
    private Person p;
    private Label label;
    private TextField nameField;
    private TextField toDoField;

    public static void main(String[] args) {
        PersonEditor.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Person Editor");

        p = new Person("Donny", 54);

        label = new Label("Person details: " + p);

        // Text field and button to change the name
        nameField = new TextField();
        nameField.setPromptText("Enter new name");
        Button changeNameBtn = new Button("Change Name");
        changeNameBtn.setOnAction(e -> updateName());

        Button increaseAgeBtn = new Button("Increase age");
        increaseAgeBtn.setOnAction(e -> {
            p.increaseAge();
            updateLabel();
        });

        Button decreaseAgeBtn = new Button("Decrease age");
        decreaseAgeBtn.setOnAction(e -> {
            p.decreaseAge();
            updateLabel();
        });

        int horizontalPadding = 5;
        HBox nameRow = new HBox(horizontalPadding, nameField, changeNameBtn);
        nameRow.setAlignment(Pos.CENTER);

        HBox ageRow = new HBox(horizontalPadding, increaseAgeBtn, decreaseAgeBtn);
        ageRow.setAlignment(Pos.CENTER);

        toDoField = new TextField();
        toDoField.setPromptText("Enter a new task to-do");
        Button addToDoBtn = new Button("Add to-do");
        addToDoBtn.setOnAction(e -> addToDoBtnClick());
        HBox toDoRow = new HBox(horizontalPadding, toDoField, addToDoBtn);
        toDoRow.setAlignment(Pos.CENTER);

        int verticalPadding = 5;
        VBox root = new VBox(verticalPadding, label, nameRow, ageRow, toDoRow);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addToDoBtnClick() 
    {
        String todo = toDoField.getText();
        if (!todo.trim().isEmpty()) {
            p.addTodo(new Todo(todo));
            toDoField.setText("");
            updateLabel();
        }
    }

    private void updateLabel() {
        label.setText("Person details: " + p);
    }

    private void updateName() {
        String newName = nameField.getText();
        if (!newName.trim().isEmpty()) {
            p.setName(newName);            
            updateLabel();
        }
    }
}