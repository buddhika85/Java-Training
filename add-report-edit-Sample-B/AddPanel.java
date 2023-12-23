import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import model.*;

public class AddPanel extends JPanel {
    private Cinema cinema;

    public AddPanel(Cinema cinema) {
        this.cinema = cinema;
        setup();
        build();
    }

    private void setup() {
        setLayout(new GridLayout(3, 1)); // r, c
    }

    private void build() {
        add(new AddMoviePanel(cinema.getMovies()));
    }

    // movies
    public class AddMoviePanel extends JPanel implements MyObserver{
        private Movies movies;
        private JTextField nameTxt = new JTextField(8);
        private JTextField costTxt = new JTextField(8);
        private JButton saveMovieBtn = new JButton("Save");
        private JLabel resultLbl = new JLabel("-");

        public AddMoviePanel(Movies movies) {
            this.movies = movies;
            setup();
            build();
            this.movies.attach(this);
        }

        private void setup() {
            setLayout(new GridLayout(4, 2)); // r, c
            saveMovieBtn.addActionListener(new SaveBtnListener());
        }

        private void build() {
            add(new JLabel("Add Movies"));
            add(Box.createHorizontalStrut(0));
            addPair("name : ", nameTxt);
            addPair("cost : ", costTxt);
            add(saveMovieBtn);
            add(resultLbl);
        }

        private void addPair(String lbl, JTextField txt) {
            add(new JLabel(lbl));
            add(txt);
        }

        private class SaveBtnListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                movies.add(nameTxt.getText(), Double.parseDouble(costTxt.getText()));
                
            }
        }

        @Override
        public void update() {
            resultLbl.setText("Movie Added");
        }

        @Override
        public void update(AddOrEdit ops) {
            if (ops == AddOrEdit.ADD)
                resultLbl.setText("Movie Added");
        } 
    }

    // sessions

    // theatres
}