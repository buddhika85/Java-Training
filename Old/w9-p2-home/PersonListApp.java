import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonListApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Person List");

        ListView<Person> listView = new ListView<>();

        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("John", "Doe", 30),
                new Person("Jane", "Doe", 25),
                new Person("Mike", "Smith", 40));

        listView.setItems(data);

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 400, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

// class Person {
//     private String firstName;
//     private String lastName;
//     private int age;

//     public Person(String fName, String lName, int age) {
//         this.firstName = fName;
//         this.lastName = lName;
//         this.age = age;
//     }

//     @Override
//     public String toString() {
//         return firstName + " " + lastName + ", Age: " + age;
//     }
// }