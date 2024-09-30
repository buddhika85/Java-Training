public class AppController 
{
    private final AppModel model;

    public AppController(AppModel model) 
    {
        this.model = model;
    }

    public void updateTodo(Todo t, int index) 
    {
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

    public void removeAll()
    {
        model.removeAll();
    }

    public void removeAllDone() 
    {
        model.removeDoneTodos();
    }
}