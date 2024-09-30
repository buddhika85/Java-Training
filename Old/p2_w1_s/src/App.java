import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) 
    {
        //testPrinter();
        //testPrinter2();

        //testCruiseShip();

        //testShuffling();

        testSpreading();
    }

    private static void testSpreading() {
    
        ArrayList<String> itinerary = new ArrayList<>();
        itinerary.add("Brisbane");
        itinerary.add("Sydney");
        itinerary.add("Melbourne");

        CruiseShip cruiseShip = new CruiseShip("My Cruise Ship", 100, itinerary);        
        cruiseShip.boardPassenger(new Passenger("Jack", "Brisbane", "Sydney"));
        cruiseShip.boardPassenger(new Passenger("Gill", "Brisbane", "Sydney"));
        cruiseShip.boardPassenger(new Passenger("John", "Brisbane", "Melbourne"));
        cruiseShip.boardPassenger(new Passenger("Harry", "Brisbane", "Sydney"));
        cruiseShip.boardPassenger(new Passenger("Ron", "Brisbane", "Sydney"));
        cruiseShip.boardPassenger(new Passenger("Hermione", "Brisbane", "Melbourne"));
        cruiseShip.boardPassenger(new Passenger("Dobby", "Brisbane", "Sydney"));
        cruiseShip.boardPassenger(new Passenger("Hagrid", "Brisbane", "Sydney"));
        cruiseShip.boardPassenger(new Passenger("Albus", "Brisbane", "Melbourne"));
        cruiseShip.boardPassenger(new Passenger("Snape", "Brisbane", "Melbourne"));
        cruiseShip.boardPassenger(new Passenger("Neville", "Brisbane", "Melbourne"));
        
        System.out.println("\nBefore infection");
        System.out.println(cruiseShip);

        cruiseShip.seedInitialCases(5);
        System.out.println("\nAfter initial Infection");
        System.out.println(cruiseShip);

        cruiseShip.spreadBug();
        System.out.println("\nAfter first spread round");
        System.out.println(cruiseShip);

        cruiseShip.spreadBug();
        System.out.println("\nAfter second spread round");
        System.out.println(cruiseShip);

    }

    private static void testShuffling() {
        ArrayList<String> fruits = new ArrayList<>(
                Arrays.asList(new String[] {"apple", "banana", "cherry"})
                );
        Collections.shuffle(fruits);
        System.out.println("After shuffling " + fruits);
    }

    private static void testCruiseShip() {

        ArrayList<String> itinerary = new ArrayList<>();
        itinerary.add("Brisbane");
        itinerary.add("Sydney");
        itinerary.add("Melbourne");
        // Route - Brisbane --> Sydney --> Melbourne

        CruiseShip cruiseShip = new CruiseShip("My Cruise Ship", 100, itinerary);
        cruiseShip.boardPassenger(new Passenger("Jack", "Brisbane", "Sydney"));
        cruiseShip.boardPassenger(new Passenger("Gill", "Brisbane", "Sydney"));
        cruiseShip.boardPassenger(new Passenger("John", "Brisbane", "Melbourne"));
        System.out.println("\t" + cruiseShip);

        cruiseShip.travelToNextStop();              // now came to Sydney, both Jack and Gill should get off 
        System.out.println("\t" + cruiseShip);

        cruiseShip.travelToNextStop();              // now came to Melbourne, Johns gets off, now empty ship
        System.out.println("\t" + cruiseShip);

        cruiseShip.travelToNextStop();              // Error - already at destination
        System.out.println("\t" + cruiseShip);
    }

    private static void testPrinter2() {
        Printer printer = new Printer("Hp", 
            2000, false, 
            true);

        printer.printJob(new PrintJob("doc1.pdf", 2, false, 2, "This is doc 1"));
        printer.printJob(new PrintJob("doc2.pdf", 3, false, 2, "This is doc 2"));
        printer.printJob(new PrintJob("doc3.pdf", 3, false, 2, "This is doc 3"));
    }

    private static void testPrinter() 
    {
        Printer printer = new Printer("Hp", 
            20, false, 
            true);
        
        System.out.println(printer);
        printer.print(21);

        printer.restock(5);
        printer.print(21);

        System.out.println(printer);
    }
}
