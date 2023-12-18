/**
 * class ConcertDriver - launches the application
 */
import model.*;
public class ConcertDriver
{
   public static void main(String[] args)
    {   
        Stadium stadium = new Stadium();
        Band band = new Band();
        Concert concert = new Concert(band, stadium);
        new ConcertWindow(concert);  
    }  
}
