// controller facilitates communication from view --> to model
public class AppController 
{
    private final AppModel model;

    public AppController(AppModel model) 
    {
        this.model = model;
    }

    // view executes this method when user tries to update a Todo object
    public void updateTodo(Todo t, int index) 
    {
        // request model to update
        this.model.updateTodo(t, index);
    }

    public void addTodo(Todo t)
    {
        this.model.addTodo(t);
    }

    public void removeTodo(int index) 
    {
        this.model.removeTodo(index);
    }
}