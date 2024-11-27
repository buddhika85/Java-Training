import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AppModel {
    private final ObservableList<Todo> todos;

    AppModel() {
        this.todos = FXCollections.observableArrayList();
    }

    public ObservableList<Todo> todosProperty() {
        return this.todos;
    }

    public void addTodo(Todo t) {
        this.todos.add(t);
    }

    public void updateTodo(Todo t, int index) {
        this.todos.set(index, t);
    }

    public void removeTodo(int index) {
        this.todos.remove(index);
    }
}

class Todo 
{
    // To wrap up enum values within a Property we can use `SimpleObjectProperty`,
    // provided by JavaFX.
    private final SimpleObjectProperty<Status> status;
    private final SimpleObjectProperty<Priority> priority;
    private final SimpleStringProperty description;

    Todo(String description, Status status, Priority priority) {
        this.description = new SimpleStringProperty(description);
        this.status = new SimpleObjectProperty<>(status);
        this.priority = new SimpleObjectProperty<>(priority);
    }

    // getters and setters
    public Status getStatus() {
        return status.get();
    }

    public Priority getPriority() {
        return priority.get();
    }

    public void setStatus(Status status) {
        this.status.set(status);
    }

    public void setPriority(Priority priority) {
        this.priority.set(priority);
    }

    public SimpleObjectProperty<Status> statusProperty() {
        return status;
    }

    public SimpleObjectProperty<Priority> priorityProperty() {
        return priority;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }
}

enum Status {
    IN_PROGRESS("In Progress"), 
    DONE("Done"), 
    WONT_COMPLETE("Won't complete");

    private String description;

    private Status(String description) {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return  description;
    }
}

enum Priority {
    LOW, MEDIUM, HIGH
}