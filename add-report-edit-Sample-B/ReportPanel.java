import javax.swing.*;
import model.AddOrEdit;
import model.Cinema;
import model.MyObserver;
import model.Record;

public class ReportPanel extends JPanel implements MyObserver
{   
    private Cinema cinema;
    private JTextArea moviesTextArea = new JTextArea();

    public ReportPanel(Cinema cinema)
    {   
        this.cinema = cinema;  
        setup();
        build();
    }

    private void setup()
    {
        moviesTextArea.setEditable(false);
        this.cinema.attach(this);
        this.cinema.getMovies().attach(this);
    }

    private void build()
    {  
        add(moviesTextArea);
    }

    @Override
    public void update() {
        for (Record movie : cinema.getMovies().getList()) 
        {
            movie.attach(this);
        }
        moviesTextArea.setText(cinema.getMovies().toString());
    }

    @Override
    public void update(AddOrEdit ops) {
        update();
    }
}
