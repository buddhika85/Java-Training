import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PersonEntity // suitable for model layer of MVC
{

    // JavaFx properties
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleIntegerProperty age;

    public PersonEntity(String fName, String lName, int age) 
    {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.age = new SimpleIntegerProperty(age);
    }

    public SimpleStringProperty firstNameProperty() {

        return firstName;
    }

    public SimpleStringProperty lastNameProperty() 
    {
        return lastName;
    }

    public SimpleIntegerProperty ageProperty() 
    {
        return age;
    }
}
