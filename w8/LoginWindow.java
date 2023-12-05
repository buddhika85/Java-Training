package w8;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginWindow extends JFrame {
    private LoginPanel loginPanel = new LoginPanel();

    public LoginWindow() {
        super("Login");
        setup();
        build();
    }

    private void build() {
        add(loginPanel);
    }

    private void setup() {
        setSize(400, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class LoginPanel extends JPanel {

        private JTextField loginTxt = new JTextField(10);
        private JPasswordField passwordTxt = new JPasswordField(10);
        private JButton loginBtn = new JButton("Login");
        private JLabel resultLbl = new JLabel();

        private final String USER_ID = "user";
        private final String PASSWORD = "abc";

        private LoginPanel() {
            setup();
            build();
        }

        private void build() {
            addPair("Login ID: ", loginTxt);
            addPair("Password: ", passwordTxt);
            add(loginBtn);
            add(resultLbl);
        }

        private void setup() {
            loginBtn.addActionListener(new LoginBtnListener());
        }

        private void addPair(String lblTxt, JTextField textField) {
            add(new JLabel(lblTxt));
            add(textField);
        }

        private class LoginBtnListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginTxt.getText().equals(USER_ID) && passwordTxt.getText().equals(PASSWORD))
                    resultLbl.setText("Login Success");
                else
                    resultLbl.setText("Login Failed");
            }
        }
    }
}
