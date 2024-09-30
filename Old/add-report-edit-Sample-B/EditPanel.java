import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import model.AddOrEdit;
import model.Cinema;
import model.Movies;
import model.MyObserver;
import model.Record;

public class EditPanel extends JPanel
{   
    private Cinema cinema;
    public EditPanel(Cinema cinema)
    {   
        this.cinema = cinema;   
        setup();
        build();
    }

    private void setup() {
        setLayout(new GridLayout(3, 1)); // r, c
    }

    private void build() {
        add(new EditMoviePanel(cinema.getMovies()));
    }

    // movies
    public class EditMoviePanel extends JPanel implements MyObserver{
      
        private JTextField idTxt = new JTextField(8);
        private JTextField nameTxt = new JTextField(8);
        private JTextField costTxt = new JTextField(8);
        private JButton saveMovieBtn = new JButton("Save");
        private JLabel resultLbl = new JLabel("-");

        public EditMoviePanel(Movies movies) {
            
            setup();
            build();

            cinema.attach(this);
            cinema.getMovies().attach(this);
        }

        private void setup() {
            setLayout(new GridLayout(5, 2)); // r, c
            saveMovieBtn.addActionListener(new SaveBtnListener());
        }

        private void build() {
            add(new JLabel("Edit Movies"));
            add(Box.createHorizontalStrut(0));
            addPair("id : ", idTxt);
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
                var movie = cinema.getMovies().find(Integer.parseInt(idTxt.getText()));
                if (movie != null)
                {
                    movie.set(nameTxt.getText(), Double.parseDouble(costTxt.getText()));
                }
                else
                {
                    resultLbl.setText("Movie with ID" + idTxt.getText() + " unavailable!");
                }
            }
        }

        @Override
        public void update() {
            resultLbl.setText("Movie Edited");
        }

        @Override
        public void update(AddOrEdit ops) {
            if (ops == AddOrEdit.EDIT)
                resultLbl.setText("Movie Edited");
            else
                for (Record movie : cinema.getMovies().getList()) {
                    movie.attach(this);
                }
        } 
    }

    // sessions

    // theatres
}
