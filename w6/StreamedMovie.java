package w6;

public class StreamedMovie {
    private double price;
    private int id;
    private String name;
    private int numDays;
    private Status status;

    public StreamedMovie(int id, String name, double price, int numDays, Status status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.numDays = numDays;
        this.status = status;
    }

    public boolean matches(int id) {
        return this.id == id;
    }

    public boolean rent() {
        if (status == Status.FOR_RENT) {
            System.out.println("\tVideo rented: " + name);
            return true;
        } else {
            System.out.println("\tVideo " + name + " is unavailable to rent");
            return false;
        }
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return status == Status.FOR_RENT;
    }

    public String getName() {
        return name;
    }

    public void show() {
        System.out.println(toString());
    }

    public String toString() {
        String str = id + " " + name + " " + numDays + " days";
        if (isAvailable())
            str += " is available for rent";
        return str;
    }
}
