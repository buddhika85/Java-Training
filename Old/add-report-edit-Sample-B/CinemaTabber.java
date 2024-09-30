/**
 * class SimpsonsTabber - an example of a tabbed pane window
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import model.Cinema;

public class CinemaTabber extends JTabbedPane
{   
    private Cinema cinema;
    public CinemaTabber(Cinema cinema)
    {   
        this.cinema = cinema;
        setup();
        build();
        setVisible(true);   
    }

    private void setup()
    {   
    }

    private void build()
    {   
        add("Add", new AddPanel(cinema));
        add("Edit", new EditPanel(cinema));
        add("Report", new ReportPanel(cinema));
    }    
}