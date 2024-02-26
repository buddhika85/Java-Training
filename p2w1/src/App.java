import java.util.ArrayList;

import lab.CruiseShip;
import lab.Passenger;

public class App {
    public static void main(String[] args) {
        // Printer printer = new Printer("Lab Printer", 5, true, true);
        // System.out.println(printer);
        // printer.print(6); // not enough
        // printer.print(1);
        // System.out.println(printer);

        // Printer printer = new Printer("Lab Printer", 100, true, true);
        // printer.printJob(new PrintJob("Volume 1.pdf", 10, 2, false, "Volume 1...."));
        // printer.printJob(new PrintJob("Volume 2.pdf", 10, 1, true, "Volume 2...."));
        // printer.printJob(new PrintJob("Volume 3.pdf", 10, 7, true, "Volume 3...."));
        // printer.printJob(new PrintJob("Volume 4.pdf", 1, 1, true, "Volume 4...."));

        // System.out.println("\n" + printer + "\n");

        //conceptCheck();

        // var point = new Point();
      
        // point.shift(10, 10);    // 1
        // point.quadrant();       
        // point.shift(-11, 0);   // 2
        // point.quadrant();
        // point.shift(0, -11);           // 3
        // point.quadrant();
        // point.shift(1, 0);            // 4
        // point.quadrant();


        // Test lab
        //testLab();

        testLoopRemoveScenario();

    }

    private static void testLoopRemoveScenario() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        int wantToRemove = 2;

        // java.util.ConcurrentModificationException
        // For Each does not support modifications while iterating
        // for (Integer num : numbers) {
        //     if (num == wantToRemove)
        //         numbers.remove(num);
        // }

        // logically wrong
        // for (int i = 0; i < numbers.size(); i++) {
        //     int num = numbers.get(i);
        //     if (num == wantToRemove)
        //         numbers.remove(i);
        // }

        // reverse - works
        for (int i = numbers.size() - 1; i >= 0; i--) {
            int num = numbers.get(i);
            if (num == wantToRemove)
                numbers.remove(i);
        }

        System.out.println("After removal");
        for (Integer num : numbers) {
            System.out.println(num);
        }
    }

    private static void testLab() {      
        var jack = new Passenger("Jack", "London", "New York");
        var gill = new Passenger("Gill", "Parris", "New York");
        var james = new Passenger("James", "Brighton", "Parris");

        var itenary = new ArrayList<String>();        
        itenary.add("London");
        itenary.add("Brighton");
        itenary.add("Parris");
        itenary.add("New York");

        var cruiseShip = new CruiseShip("Summer Travels", 10, itenary);

        // now at London
        System.out.println(cruiseShip.boardPassenger(jack));    // true
        System.out.println(cruiseShip.boardPassenger(gill));    // false - still at London

        // Brighton
        cruiseShip.travelToNextStop();                          // nobody gets off       

        // Parris
        cruiseShip.travelToNextStop();                          // James gets off
        System.out.println(cruiseShip.boardPassenger(gill));    // true

        // New York
        cruiseShip.travelToNextStop();                          //Jack, Gill gets off

        // You cannot go further
        cruiseShip.travelToNextStop();    
    }

    private static void conceptCheck() {
        for (int i = 20; i >= 7; i--)
            System.out.println(i);

        int i = 20;
        while (i >= 7) {
            System.out.println(i);
            i--;
        }
    }
}