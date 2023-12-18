import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class PriceWindow extends JFrame
{   
    private Stadium stadium;
    public PriceWindow(Stadium stadium)
    {   super("Price Window");
        setup();
        this.stadium = stadium;
        build();
        setVisible(true);   
    }
    private void setup()
    {   
        setSize(450, 200);
        setLayout(new GridLayout(2, 1)); 
    }
    private void build()
    {   
        add(new PricePanel());    
    }
    private void close()
    {
        setVisible(false);  
    }
    private class PricePanel extends JPanel implements MyObserver
    {   
        private JTextField rent = new JTextField(6);
        private JButton button = new JButton("Set");
        private JTextField[] seatPrices;
        public PricePanel()
        {
            setup();
            build();
        }
        private void build()
        {   
            addPair("Stadium rent", rent);
            addPrices();
            add(button);    
        }
        private void addPair(String label, JTextField field)
        { 
            add(new JLabel(label));
            add(field);    
        }
        private void setup()
        {   
            PriceListener listener = new PriceListener();
            button.addActionListener(listener);    
        }
        public void update()
        {
        }
        private void addPrices()
        {   
            int groups = stadium.groups();
            seatPrices = new JTextField[groups];
            for(int i = 0; i < groups; i++)
            {   
                seatPrices[i] = new JTextField(5);
                Seat seat = stadium.seats().get(i);
                addPair(seat.name() + " seats", seatPrices[i]); 
            }
        }
        public double rent()
        {
            return Double.parseDouble(rent.getText());
        }
        public double[] prices()
        {   
            int length = seatPrices.length;
            double[] prices = new double[length];
            for (int i = 0; i < length; i++)
            {   
                String price = seatPrices[i].getText();
                prices[i] = Double.parseDouble(price);  
            }
            return prices;  
        }
        //inner class
        private class PriceListener implements ActionListener
        {   
            public PriceListener()
            {    
            }
            public void actionPerformed(ActionEvent e)
            {   
                stadium.setRent(rent());
                stadium.setPrices(prices());
                close(); 
            }
        }
    }
}