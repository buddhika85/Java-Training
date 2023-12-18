import model.*;
import javax.swing.*;
import java.awt.*;
public class ConcertWindow extends JFrame
{   
    public ConcertWindow(Concert concert)
    {   
        setup();
        build(concert);
        setVisible(true);   
    }
    private void setup()
    {   
        setSize(350, 200);
        setTitle("Concerted efforts productions");
        setLayout(new GridLayout(2, 1)); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void build(Concert concert)
    {   
        add(new ControlPanel(concert));//has the JButtons
        add(new DisplayPanel(concert));  //has the JLabels and JTextFields
    }
}
