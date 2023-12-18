import model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class SaleWindow extends JFrame
{   
    public SaleWindow(Stadium stadium)
    {   
        super("Sale Window");
        setup(stadium.groups());
        build(stadium);  
    }
    private void setup(int rows)
    {   
        setSize(600, 100);
        setLayout(new GridLayout(rows, 1)); 
    }    
    private void build(Stadium stadium)
    {   
        Iterator<Seat> it = stadium.seats().iterator();
        while (it.hasNext())
           add(new SalePanel(it.next()));
        setVisible(true);   
    }
    private class SalePanel extends JPanel implements MyObserver
    {   
        private JTextField sold = new JTextField(5);
        private JTextField left = new JTextField(5);
        private JTextField sale = new JTextField(5);
        private JButton button = new JButton("Sell");
        private Seat seat;
        public SalePanel(Seat seat)
        {   
            this.seat = seat;
            setup(seat);
            build(seat.name());  
        } 
        private void setup(Seat seat)
        {   
            SaleListener listener = new SaleListener(seat);
            button.addActionListener(listener);
            seat.attach(this);  
        }
        private void build(String name)
        {   
            add(new JLabel(name + " seats    "));
            addPair("Sold", sold);
            addPair("Left", left);
            addPair("Sell", sale);
            add(button);
            update();   
        }  
        private void addPair(String label, JTextField field)
        { 
            add(new JLabel(label));
            add(field);    
        }
        public void update()
        {   
            sold.setText(seat.sold() + "");
            left.setText(seat.left() + "");
            sale.setText("");   
        }
        private int sale()
        {   
            return Integer.parseInt(sale.getText()); 
        }
        //inner class
        private class SaleListener implements ActionListener
        {   
            private Seat seat;
            public SaleListener(Seat seat)
            {   
                this.seat = seat;
            }
            public void actionPerformed(ActionEvent e)
            {   
                seat.sell(sale());  
            }
        }

    }
}