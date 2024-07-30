/*

if you want to display a Form Label with a tool tip and other accessibility features in JavaFx go for label.
When you want to display Text outputs - go for Text control.

Label vs Text
-------------
Interactivity: Label supports more built-in features such as tooltips, mnemonics, and accessibility features.
Layout and Styling: Text provides more control over the text's layout and styling, including transformations like rotation, scaling, and advanced font styling.
Use Cases: Use Text when you need fine-grained control over the appearance and behavior of text. Use Label for simpler text displays, 
especially within UI layouts where built-in features like alignment and padding are useful.

 * When you run this application, you will see the Text node with rotation, translation, and underlining, 
 * while the Label node displays with a tooltip, wrapping text, and specific alignment. 
 * This demonstrates the unique capabilities and intended use cases for each control.
 


 Mnemonics in JavaFX are keyboard shortcuts that allow users to quickly access or activate controls, 
 such as buttons, menu items, or other interactive elements. Mnemonics provide a way to improve the usability and accessibility of applications by enabling keyboard navigation and control.

How to Use Mnemonics in JavaFX
Set Mnemonics: You can set mnemonics for controls by including an underscore (_) before the character you want to use as the mnemonic in the control's text.
Enable Mnemonics: Mnemonics are enabled by default, but they work only when the control is focused or when the user presses the Alt key.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextVsLabelExample extends Application 
{
    @Override
    public void start(Stage primaryStage) 
    {

        // Create a Label node with a tooltip and alignment
        Label label = new Label("This is a Label node.");
        label.setFont(new Font("Arial", 20));
        label.setUnderline(true);        

        // label.setFill(Color.BLUE);            // cannot        
        label.setTooltip(new Tooltip("This is a tooltip for the label."));




        // Create a Text node with transformations and advanced styling
        Text text = new Text("This is a Text node.");
        text.setFont(new Font("Arial", 20));
        text.setUnderline(true); // Underline the text  

        //text.setTooltip(new Tooltip("This is a tooltip for the label."));            // cannot        
        text.setFill(Color.BLUE);   

        
        // Add Text and Label to a VBox
        VBox vbox = new VBox(20); // 20px spacing
        vbox.getChildren().addAll(text, label);

        // Create a scene and add it to the stage
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Text vs Label Example");
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
