import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExampleWithEvents extends Application 
{    
    private int number;

    public static void main(String[] args) {
        ExampleWithEvents.launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Exmple - Events");

       
        Label resultLbl = new Label("Result is  " + number);
        Label oddEventLbl = new Label("0 is EVEN");

        Button btnAddOne = new Button("Add One");        
        btnAddOne.setOnAction(event -> {           
            number++;
            resultLbl.setText("Result is  " + number);
            if (number % 2 == 0)
            {
                oddEventLbl.setText(number + " is EVEN");
            }
            else
            {
                oddEventLbl.setText(number + " is ODD");
            }
        });

        Button btnAddTwo = new Button("Add Two");
        btnAddTwo.setOnAction(event -> {           
            number += 2;
            resultLbl.setText("Result is  " + number);
            if (number % 2 == 0)
            {
                oddEventLbl.setText(number + " is EVEN");
            }
            else
            {
                oddEventLbl.setText(number + " is ODD");
            }
        });

        Button btnAddThree = new Button("Add Three");
        btnAddThree.setOnAction(event -> {           
            number += 3;
            resultLbl.setText("Result is  " + number);
            if (number % 2 == 0)
            {
                oddEventLbl.setText(number + " is EVEN");
            }
            else
            {
                oddEventLbl.setText(number + " is ODD");
            }
        });

        Button btnAddTen = new Button("Add 10"); 
        btnAddTen.setOnAction(event -> {
            number += 10;
            resultLbl.setText("Result is  " + number);
            if (number % 2 == 0)
            {
                oddEventLbl.setText(number + " is EVEN");
            }
            else
            {
                oddEventLbl.setText(number + " is ODD");
            }
        });

        Button btnAddTwenty = new Button("Add 20"); 
        btnAddTwenty.setOnAction(event -> {
            number += 20;
            resultLbl.setText("Result is  " + number);
            if (number % 2 == 0)
            {
                oddEventLbl.setText(number + " is EVEN");
            }
            else
            {
                oddEventLbl.setText(number + " is ODD");
            }
        });


        int padding = 5;
        VBox root = new VBox(5, resultLbl, oddEventLbl, btnAddOne, btnAddTwo, btnAddThree, btnAddTen, btnAddTwenty);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
