import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class CruiseShipTest
{
    public static void main(String[] args) 
    {
        System.out.println("CruiseShip Test");
        //testCruiseShip();
        testSpreading();
    }


    private static void testCruiseShip() 
    {

        ArrayList<String> itinerary = new ArrayList<>();
        itinerary.add("Brisbane");
        itinerary.add("Sydney");
        itinerary.add("Melbourne");
        // Route - Brisbane --> Sydney --> Melbourne

        CruiseShip cruiseShip = new CruiseShip("Cruise Ship", 100, itinerary);
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


    private static void testSpreading() 
    {
    
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
}


public class CruiseShip 
{
    String shipName;
    int capacity;
    ArrayList<String> itinerary;
    String currentLocation;
    int currentLocationIndex;
    ArrayList<Passenger> passengers;

    public CruiseShip(String shipName, int capacity, ArrayList<String> itinerary) 
    {
        this.shipName = shipName;
        this.capacity = capacity;
        this.itinerary = itinerary;
        this.currentLocation = itinerary.get(0);      // we are at start location
        this.currentLocationIndex = 0;
        this.passengers = new ArrayList<>();
    }

    public boolean boardPassenger(Passenger p)
    {
        if (p.getBoardingLocation().equals(currentLocation))
        {
            passengers.add(p);
            return true;
        }

        System.out.println("Error - unable to board, passenger boarding location " + p.getBoardingLocation() + 
            ", but ship is at " + currentLocation);
        return false;
    }

    public void travelToNextStop()
    {
        if (currentLocationIndex == itinerary.size() - 1)     // last possible itenary index = itinerary.size() - 1
        {
            System.out.println("Ship already at the destination");
            return;
        }

        // go to next location
        currentLocation = itinerary.get(++currentLocationIndex);
        System.out.println("Arrived to - " + currentLocation);
        // remove passengers
        for (int i = passengers.size() - 1; i >= 0; i--) 
        {
            if (passengers.get(i).getDisembarkLocation().equals(currentLocation))
            {                
                System.out.println(passengers.get(i).getName() + "' disembark location is " 
                    + passengers.get(i).getDisembarkLocation() + ". So, getting off.");
                    passengers.remove(i);
            }
        }
    }

    // TB
    // randomly selects n passengers to be sick.
    // assumption: n is always less than or equal to passenger count
    public void seedInitialCases(int n)
    {
        // shuffle a list of Passengers - now it will not maintain the insertion order
        Collections.shuffle(passengers);

        // make passenger sick
        for (int i = 0; i < n; i++) {
            passengers.get(i).getSick();
        }
    }

    // iterate through the passengers ArrayList and 
    // for each passenger that is sick, there is a 10% chance to spread it to another passenger. 
    // So you will need to draw up to 2 random numbers; first whether it will be spread, and if so, spread to whom.
    public void spreadBug()
    {
        for (Passenger passenger : passengers) {
            // to spread first the passenger should already be sick
            if (passenger.isSick)
            {
                // check 10% chance of spreading
                if (willSpread())
                {
                    // to whome do we spread ?
                    int spreadPassengerIndex = new Random().nextInt(passengers.size());

                    // making that passenger sick
                    passengers.get(spreadPassengerIndex).getSick();
                }
            }
        }
    }

    // there is a 10% chance to spread it to another passenger. 
    // returns true - if spreading
    // returns false - if not spreading
    private boolean willSpread() 
    {
        // int num = new Random().nextInt(10); // 0,1,2,3,4,5,6,7,8,9 - if 0 it is considered as 10% chance
        // return num == 0;

        int num = new Random().nextInt(10); // 0,1,2,3,4,  5,6,7,8,9 
        return num != 0;        // 90 % chance now
    }

    @Override
    public String toString() {
        String str = shipName + ", At: " + currentLocation + ", itinerary = " + itinerary + ", Passengers inside the ship:";
        if (passengers.size() == 0)
        {
            str += "\n\t\t" + "Empty";
        }
        else
        {
            for (Passenger passenger : passengers) {
                str += "\n\t\t" + passenger;
            }
        }
        return str;
    }
}

class Passenger 
{
    private String name;
    private String boardingLocation;
    private String disembarkLocation;

    boolean isSick = false;                         //  TB
    
    public Passenger(String name, String boardingLocation, String disembarkLocation) {
        this.name = name;
        this.boardingLocation = boardingLocation;
        this.disembarkLocation = disembarkLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoardingLocation() {
        return boardingLocation;
    }

    public void setBoardingLocation(String boardingLocation) {
        this.boardingLocation = boardingLocation;
    }

    public String getDisembarkLocation() {
        return disembarkLocation;
    }

    public void setDisembarkLocation(String disembarkLocation) {
        this.disembarkLocation = disembarkLocation;
    }

    // TB
    public void getSick()
    {
        isSick = true;
    }

    // TB
    public void recover()
    {
        isSick = false;
    }

    // @Override
    // public String toString() 
    // {
    //     return "Passenger [name=" + name + ", boardingLocation=" + boardingLocation + ", disembarkLocation="
    //             + disembarkLocation + "]";
    // }

    // TB
    @Override
    public String toString() {
        String str = "Name = " + name + ", is sick = ";
        if (isSick)
            str += "YES.................";
        else
            str += "no";
        return str;
    }
}
