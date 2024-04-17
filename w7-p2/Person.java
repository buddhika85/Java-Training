import java.util.LinkedList;
import java.util.List;

public class Person {
    String name;
    int age;
    private List<Todo> todos = new LinkedList<>();

    Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    public String toString() {
        String str = this.name + ", aged: " + this.age;
        for (Todo todo : todos) {
            str += "\n-" + todo;
        }
        return str;
    }
}