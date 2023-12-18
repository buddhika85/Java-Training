import model.*;
import javax.swing.*;
import java.awt.event.*;

public class ControlPanel extends JPanel {
    private Concert concert;
    private JButton setBandBtn = new JButton("Set Band");
    private JButton setPricesBtn = new JButton("Set Prices");
    private JButton sellBtn = new JButton("Sell");
    private JButton exitBtn = new JButton("Exit");

    public ControlPanel(Concert concert) {
        this.concert = concert;
        // call setup & build
        setup();
        build();
    }

    // setup - set the listeners
    private void setup(){
        setBandBtn.addActionListener(new BandListener(concert.band()));
        setPricesBtn.addActionListener(new PriceListener(concert.stadium()));
        sellBtn.addActionListener(new SaleListener(concert.stadium()));
        exitBtn.addActionListener(new ExitListener());
    }

    // build - add the components
    private void build(){
        add(setBandBtn);
        add(setPricesBtn);
        add(sellBtn);
        add(exitBtn);
    }

    ////// inner class
    private class BandListener implements ActionListener {
        private Band band;

        public BandListener(Band band) {
            this.band = band;
        }

        public void actionPerformed(ActionEvent e) {
            new BandWindow(band);
        }
    }

    ////// inner class
    private class PriceListener implements ActionListener {
        private Stadium stadium;

        public PriceListener(Stadium stadium) {
            this.stadium = stadium;
        }

        public void actionPerformed(ActionEvent e) {
            new PriceWindow(stadium);
        }
    }

    ////// inner class
    private class SaleListener implements ActionListener {
        private Stadium stadium;

        public SaleListener(Stadium stadium) {
            this.stadium = stadium;
        }

        public void actionPerformed(ActionEvent e) {
            new SaleWindow(stadium);
        }
    }

    //// inner class
    private class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
