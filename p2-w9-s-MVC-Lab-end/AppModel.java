import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AppModel 
{
    // ObservableList attribute
    private final ObservableList<Todo> todos;

    AppModel() 
    {
        this.todos = FXCollections.observableArrayList();       // intializes to empty ObservableList
    }

    // getter
    public ObservableList<Todo> todosProperty() 
    {
        return this.todos;
    }

    // add
    public void addTodo(Todo t) 
    {
        this.todos.add(t);
    }

    // update
    public void updateTodo(Todo t, int index) 
    {
        // replace indexes Todo object with t object passed
        this.todos.set(index, t);
    }

    // delete
    public void removeTodo(int index) 
    {
        // delete indexes todo object
        this.todos.remove(index);
    }

    public void removeAll() 
    {
        todos.clear();
    }

    public void removeDoneTodos() 
    {        
        if (!todos.isEmpty()) 
        {
            for (int i = todos.size() - 1; i >= 0; i--) 
            {
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

    Todo(String description, Status status, Priority priority) 
    {
        // intialize properties
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

    // Priority
    public Priority getPriority() {
        return priority.get();
    }

    public void setPriority(Priority status) {
        this.priority.set(status);
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

    @Override
    public String toString() {
        return  description + " - " + status;
    }
}

enum Status 
{
    IN_PROGRESS("In Progress"), 
    DONE("Done"), 
    WONT_COMPLETE("Won't Complete");

    private String description;

    private Status(String description)
    {
        this.description = description;
    }
    
    @Override
    public String toString()
    {
        return description;
    }
}

enum Priority 
{
    LOW("Low"), 
    MEDIUM("Medium"), 
    HIGH("High");

    private String description;

    private Priority(String description)
    {
        this.description = description;
    }
    
    @Override
    public String toString()
    {
        return description;
    }
}




// class Person 
// {
//     // JavaFx properties
//     private final SimpleStringProperty firstName;
//     private final SimpleStringProperty lastName;
//     private final SimpleIntegerProperty age;

//     public Person(String fName, String lName, int age) 
//     {
//         // intialize properties
//         this.firstName = new SimpleStringProperty(fName);
//         this.lastName = new SimpleStringProperty(lName);
//         this.age = new SimpleIntegerProperty(age);
//     }

//     // getters
//     public SimpleStringProperty firstNameProperty() 
//     {
//         return firstName;
//     }

//     public SimpleStringProperty lastNameProperty() 
//     {
//         return lastName;
//     }

//     public SimpleIntegerProperty ageProperty() 
//     {
//         return age;
//     }
// }