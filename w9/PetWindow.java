import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.*;
import model.*;

public class PetWindow extends JFrame {
    private PetPanel panel;
    private Pet pet;

    public PetWindow(Pet pet) {
        super("Pet Store");
        this.pet = pet;
        panel = new PetPanel();
        setup();
        build();
        setVisible(true);
    }

    private void setup() {
        setSize(400, 100);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void build() {
        add(panel);
    }

    private class PetPanel extends JPanel implements MyObserver {

        private JTextField idTxt = new JTextField(4);
        private JTextField nameTxt = new JTextField(18);
        private JButton setBtn = new JButton("Set");
        private JLabel resultLbl = new JLabel();

        public PetPanel() {

            pet.attach(this);
            setup();
            build();
        }

        private void setup() {
            setBtn.addActionListener(new SetActionListener());
        }

        private void build() {
            addPair("Id: ", idTxt);
            addPair("Pet Name: ", nameTxt);
            add(setBtn);
            add(resultLbl);
        }

        private void addPair(String lbl, JTextField txt) {
            add(new JLabel(lbl));
            add(txt);
        }

        @Override
        public void update() {
            resultLbl.setText("Pet Saved:: " + pet);
        }

        private class SetActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                // resultLbl.setText("Clicked");
                pet.set(Integer.parseInt(idTxt.getText()), nameTxt.getText());
            }
        }
    }
}
