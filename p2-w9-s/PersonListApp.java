import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonListApp extends Application 
{

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Person List");

        ListView<Person> listView = new ListView<>();

        // create an ObservableList
        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("John", "Doe", 30),
                new Person("Jane", "Doe", 25),
                new Person("Mike", "Smith", 40));

        //List<Person> data = new ArrayList<>();        // won't work

        listView.setItems(data);        // list view accepts only an observable list to observe

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 400, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
