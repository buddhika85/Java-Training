import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExampleWithPropertyBinding extends Application 
{    
    private SimpleIntegerProperty number = new SimpleIntegerProperty(0);

    public static void main(String[] args) {
        ExampleWithPropertyBinding.launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Exmple - Property Binding");
       
        Label resultLbl = new Label();
        resultLbl.textProperty().bind(number.asString("Result is  %d"));
        Label oddEventLbl = new Label(number.get() + " is EVEN");
        number.addListener((observableValue, oldValue, newValue) -> {
            int newValueAsInt = newValue.intValue();
            if (newValueAsInt % 2 == 0)
            {
                oddEventLbl.setText(newValueAsInt + " is EVEN");
            }
            else
            {
                oddEventLbl.setText(newValueAsInt + " is ODD");
            }
        });

        Button btnAddOne = new Button("Add One");         
        btnAddOne.setOnAction(event -> {
            number.set(number.get() + 1);
        });

        Button btnAddTwo = new Button("Add Two"); 
        btnAddTwo.setOnAction(event -> {
            number.set(number.get() + 2);
        });

        Button btnAddThree = new Button("Add Three"); 
        btnAddThree.setOnAction(event -> {
            number.set(number.get() + 3);
        });

        Button btnAddTen = new Button("Add 10"); 
        btnAddTen.setOnAction(event -> {
            number.set(number.get() + 10);
        });

        Button btnAddTwenty = new Button("Add 20"); 
        btnAddTwenty.setOnAction(event -> {
            number.set(number.get() + 20);
        });

        int padding = 5;
        VBox root = new VBox(5, resultLbl, oddEventLbl, btnAddOne, btnAddTwo, btnAddThree, btnAddTen, btnAddTwenty);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}