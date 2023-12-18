import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class BandWindow extends JFrame
{   
    private Band band;
    public BandWindow(Band band)
    {   super("Band Window");
        setup();
        this.band = band;
        build();
        setVisible(true);   
    }
    private void setup()
    {   
        setSize(450, 100);
        setLayout(new GridLayout(2, 1)); 
    }
    private void build()
    {   
        add(new BandPanel());    
    }
    private void close()
    {
        setVisible(false);
    }
    private class BandPanel extends JPanel implements MyObserver
    {   
        private JTextField name = new JTextField(20);
        private JTextField cost = new JTextField(6);
        private JButton button = new JButton("Set");
        public BandPanel()
        {   
            setup();
            build();    
        }
        private void build()
        {   
            addPair("Name", name);
            addPair("Cost", cost);
            add(button);    
        }       
        public void addPair(String label, JTextField field)
        { 
            add(new JLabel(label));
            add(field);    
        }
        private void setup()
        {   
            BandListener listener = new BandListener();
            button.addActionListener(listener);    
        }
        public String name()
        {   
            return name.getText();  
        }
        public double cost()
        {      
            return Double.parseDouble(cost.getText());
        }
        public void update()
        {
        }
        private class BandListener implements ActionListener
        {   
            public BandListener()
            {   
            }
            public void actionPerformed(ActionEvent e)
            {   
                band.setup(name(), cost());
                close();  
            }
        }
    }
}
