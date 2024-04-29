import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AppModel 
{
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

	public void removeAll() 
    {
        todos.clear();
	}

    public void removeDoneTodos() {
        if (!todos.isEmpty()) {
            for (int i = todos.size() - 1; i >= 0; i--) {
               // If the Todo object at index i is DONE, remove it.
               if (todos.get(i).getStatus() == Status.DONE)
                    todos.remove(i);
            }
        }
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

    public void setStatus(Status status) {
        this.status.set(status);
    }

    public SimpleObjectProperty<Status> statusProperty() {
        return status;
    }

    public Priority getPriority() {
        return priority.get();
    }

    public void setPriority(Priority priority) {
        this.priority.set(priority);
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

enum Status 
{
    IN_PROGRESS("In Progress"), DONE("Done"), WONT_COMPLETE ("Won't Complete");
    private final String DISPLAY_STR;
    private Status(String displayStr) 
    {
        DISPLAY_STR = displayStr;
    }
    @Override
    public String toString()
    {
        return DISPLAY_STR;
    }
}

enum Priority {
    LOW, MEDIUM, HIGH
}


class Person {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleIntegerProperty age;

    public Person(String fName, String lName, int age) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.age = new SimpleIntegerProperty(age);
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }
}