package lab;

public class Passenger {
    private String name, boardingLocation, disembarkLocation;
   
    public Passenger(String name, String boardingLocation, String disembarkLocation) {
        setName(name);
        setBoardingLocation(boardingLocation);
        setDisembarkLocation(disembarkLocation);
    }

    public String getDisembarkLocation() {
        return disembarkLocation;
    }
    public void setDisembarkLocation(String disembarkLocation) {
        this.disembarkLocation = disembarkLocation;
    }
    public String getBoardingLocation() {
        return boardingLocation;
    }
    public void setBoardingLocation(String boardingLocation) {
        this.boardingLocation = boardingLocation;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name + " " + boardingLocation + " " + disembarkLocation;
    }
}
