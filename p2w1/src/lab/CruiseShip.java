package lab;

import java.util.ArrayList;

public class CruiseShip {
    private String shipName;
    private int capacity;
    private ArrayList<String> itinerary;
    private String currentLocation;
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public CruiseShip(String shipName, int capacity, ArrayList<String> itinerary) {
        this.shipName = shipName;
        this.capacity = capacity;
        this.itinerary = itinerary; 
        this.currentLocation = itinerary.get(0);        // ship is at first location
    }

    public boolean boardPassenger(Passenger passenger)
    {
        if (passenger.getBoardingLocation() == null || currentLocation == null)
            return false;
        if (!passenger.getBoardingLocation().equals(currentLocation))
            return false;
        
        passengers.add(passenger);
        return true;
    }

    public void travelToNextStop()
    {
        // current index
        int currentLocationIndex = getCurrentLocationIndex();
        boolean isAtEnd = isAtEnd(currentLocationIndex);
        if (isAtEnd)
        {
            System.out.println("Ship already at the final stop, cannot go more.");
            return;
        }

        // go to next stop
        currentLocation = itinerary.get(currentLocationIndex + 1);
        // remove all at this stop
        disembarkPassengers();
    }



    private void disembarkPassengers() 
    {
        int disembarkCount = 0;
        for (int i = passengers.size() - 1; i >= 0; i--) 
        {
            var passenger = passengers.get(i);        
            if (passenger.getDisembarkLocation() != null && passenger.getDisembarkLocation().equals(currentLocation))
            {
                passengers.remove(i);
                System.out.println("At " + currentLocation + " - " + passenger.getName() + " --> getting off\n");
                ++disembarkCount;
            }
        }

        if (disembarkCount == 0)
        {
            System.out.println("At " + currentLocation + " - Npbody got off \n");
        }
    }

    private boolean isAtEnd(int currentLocationIndex) {
        return currentLocationIndex == itinerary.size() - 1;
    }

    private int getCurrentLocationIndex() {
        return itinerary.indexOf(currentLocation);
    }
}
