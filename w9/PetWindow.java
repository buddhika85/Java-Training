import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PetWindow extends JFrame {
    private PetPanel panel = new PetPanel();
    public PetWindow() {
        super("Pet Store");
        setup();
        build();
        setVisible(true);
    }

    private void setup(){
        setSize(400, 100);
        setLocation(100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void build(){
        add(panel);
    }

    private class PetPanel extends JPanel{

        private JTextField idTxt  = new JTextField(5);
        private JTextField nameTxt =  new JTextField(20);
        private JButton setBtn = new JButton("Set");
        private JLabel resultLbl = new JLabel();

        public PetPanel() {        
            setup();
            build();
        }
       

        private void setup(){}

        private void build(){
            addPair("Id: ", idTxt);
            addPair("Pet Name: ", nameTxt);
            add(setBtn);
            add(resultLbl);
        }

        private void addPair(String lbl, JTextField txt)
        {
            add(new JLabel(lbl));
            add(txt);
        }
    }
}
