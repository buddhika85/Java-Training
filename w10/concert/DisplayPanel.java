import model.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class DisplayPanel extends JPanel implements MyObserver
{   
    private Concert concert;
    private JTextField incomeTxt = new JTextField(8);
    private JTextField costTxt = new JTextField(8);
    private JTextField profitTxt = new JTextField(8);

    //add GUI components
    public DisplayPanel(Concert concert)
    {
        this.concert = concert;
        //call setup and build
        setup();
        build();
    }

    // setup - attach Observer to Concert
    //         attach Observer to Band    
    //         attach Observer to Stadium
    //         attach Observer to each Seat
    private void setup(){
        //concert.attach(this);
        concert.band().attach(this);
        concert.stadium().attach(this);
        for (Seat seat : concert.stadium().seats()) {
            seat.attach(this);
        }
    }

    // build - to add components to the panel
    private void build(){
        addPair("Income $", incomeTxt);
        addPair("Cost $", costTxt);
        addPair("Profit $", profitTxt);
    }

    private void addPair(String lbl, JTextField txt)
    {
        add(new JLabel(lbl));
        add(txt);
    }

    @Override
    public void update() {
        incomeTxt.setText(concert.income());
        costTxt.setText(concert.cost());
        profitTxt.setText(concert.profit());
    }
   
}

