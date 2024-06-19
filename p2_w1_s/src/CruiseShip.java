import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CruiseShip {
    private String shipName;
    private int capacity;
    private String currentLocation;
    private ArrayList<String> itinerary;
    private ArrayList<Passenger> passengers 
        = new ArrayList<>();        // no passengers

    public CruiseShip(String shipName, int capacity, ArrayList<String> itinerary)
    {
        this.shipName = shipName;
        this.capacity = capacity;
        this.itinerary = itinerary;
        this.currentLocation = this.itinerary.get(0);
    }

    public boolean boardPassenger(Passenger passenger)
    {
        if (!passenger.getBoardingLocation().equals(currentLocation))
            return false;
        
        passengers.add(passenger);
        //System.out.println("\tBOARDED --> " + passenger);
        return true;
    }

    public void travelToNextStop()
    {
        if (isAtDestination())
        {
            System.out.println("\nError: Ship is already at the destination: " + currentLocation + ", cannot go further !");
            return;     // return back to the caller
        }

        int currentLocationIndex = getCurrentLocationIndex();
        if (currentLocationIndex == -1)
            return;

        currentLocation = itinerary.get(currentLocationIndex + 1);
        System.out.println("\nArrived at " + currentLocation);
        disembarkPassengers();
    }

    private void disembarkPassengers() 
    {
        // left to right iteration (forward) - unstable indexing - does not work
        // for (int i = 0; i < passengers.size(); i++) {
        //     Passenger passenger =  passengers.get(i);
        //     if (passenger.getDisembarkLocation().equals(currentLocation))
        //     {
        //         passengers.remove(passenger);
        //         System.out.println("\tDISEMBARKING --> " + passenger);
        //     }
        // }

        // right/end to left/start iteration (reverse) - works
        for (int i = passengers.size() - 1; i >= 0; i--) {
            Passenger passenger =  passengers.get(i);
            if (passenger.getDisembarkLocation().equals(currentLocation))
            {
                passengers.remove(passenger);
                System.out.println("\tDISEMBARKING --> " + passenger);
            }
        }
    }

    private int getCurrentLocationIndex() 
    {
        for (int i = 0; i < itinerary.size(); i++) {
            if (itinerary.get(i).equals(currentLocation))
                return i;
        }
        return -1;      // invalid current location
    }

    private boolean isAtDestination() 
    {
        return currentLocation.equals(itinerary.getLast());
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
            if (passenger.isSick())
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
}