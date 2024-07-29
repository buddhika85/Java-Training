import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PersonEditor extends Application 
{
    private Person p;
    private Label label;
    private TextField nameField;
    private TextField todoField;

    public static void main(String[] args) 
    {
        PersonEditor.launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
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

        // To dos
        todoField = new TextField();
        Button addToDoBtn = new Button("Add To Do");
        addToDoBtn.setOnAction(event -> {
            String toDoText = todoField.getText();
            if (!toDoText.trim().isEmpty())
            {
                p.addTodo(new Todo(todoField.getText()));
                updateLabel();
                todoField.setText("");
            }
        });
        

        int horizontalPadding = 5;
        HBox nameRow = new HBox(horizontalPadding, nameField, changeNameBtn);
        nameRow.setAlignment(Pos.CENTER);

        HBox ageRow = new HBox(horizontalPadding, increaseAgeBtn, decreaseAgeBtn);
        ageRow.setAlignment(Pos.CENTER);

        HBox todoRow = new HBox(horizontalPadding, todoField, addToDoBtn);
        todoRow.setAlignment(Pos.CENTER);

        int verticalPadding = 5;
        VBox root = new VBox(verticalPadding, label, nameRow, ageRow, todoRow);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
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

class Person 
{
    String name;
    int age;
    List<Todo> todos;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.todos = new ArrayList<>();
    }

    public void addTodo(Todo task)
    {
        todos.add(task);
    }

    void increaseAge() {
        this.age += 1;
    }

    void decreaseAge() {
        this.age -= 1;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() 
    {
        String str = this.name + ", aged: " + this.age;
        for (Todo todo : todos) {
            str += "\n    - " + todo;
        }
        return str;
    }
}