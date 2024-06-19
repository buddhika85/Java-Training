public class Passenger
{
    private String name;
    private String boardingLocation;
    private String disembarkLocation;

    private boolean isSick;    


    public Passenger(String name, String boardingLocation, String disembarkLocation) {
        this.name = name;
        this.boardingLocation = boardingLocation;
        this.disembarkLocation = disembarkLocation;
    }

    public void getSick()
    {
        isSick = true;
    }

    public void recover()
    {
        isSick = false;
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

    public boolean isSick() {
        return isSick;
    }

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