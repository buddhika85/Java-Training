import model.Cinema;

public class Root
{
    public Root()
    {
        Cinema cinema = new Cinema();
        new CinemaTabbedPaneWindow(cinema);
    }

    public static void main(String[] args) {
        new Root();
    }
}
