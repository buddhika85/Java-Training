public class Q2 {
    public static void main(String[] args) {
        // 2.3
        GreenManalishi greenManalishi = new GreenManalishi(2);
        System.out.println(greenManalishi);

        // 2.4
        GreenManalishi [] manas = { new GreenManalishi(3), 
            new GreenManalishi(2), new GreenManalishi(6)};
        for (GreenManalishi gm : manas) {
            System.out.println(gm);
        }
    }
}

class GreenManalishi {
    private int numberOfProngsOnCrown;

    GreenManalishi(int numberOfProngs) {
        this.numberOfProngsOnCrown = numberOfProngs;
    }

    public int getProngs() {
        return this.numberOfProngsOnCrown;
    }

    public void setNumberOfProngsOnCrown(int numberOfProngsOnCrown)
    {
        this.numberOfProngsOnCrown = numberOfProngsOnCrown;
    }


    public String toString() {
        return "It's the Green Manalishi (with the " +
                this.numberOfProngsOnCrown + "-pronged crown)";

    }
}