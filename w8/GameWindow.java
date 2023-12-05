package w8;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame
{
    private MyPanel panel = new MyPanel();  
    private Dice dice = new Dice();

    public GameWindow()
    {
        super("Great Games");
        setup();
        build();
        setVisible(true);   
    }

    public void setup()
    {
        setSize(400, 200);
        setLocation(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void build()
    {
        add(panel);
    }
    private class MyPanel extends JPanel
    {
        private JButton button = new JButton("Roll");
        private JLabel label = new JLabel();

        public MyPanel()
        {
            setup();
            build(); 
        } 

        private void setup()
        {
            button.addActionListener(new Listener());
        }

        private void build()
        {
            add(button);
            add(label);
        }
        private class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                label.setText("" + dice.roll());//making changes to the window
            }
        }
    }

}