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

        //coneptCheck();

        var point = new Point();
      
        point.shift(10, 10);    // 1
        point.quadrant();       
        point.shift(-11, 0);   // 2
        point.quadrant();
        point.shift(0, -11);           // 3
        point.quadrant();
        point.shift(1, 0);            // 4
        point.quadrant();
    }

    private static void coneptCheck() {
        for (int i = 20; i >= 7; i--)
            System.out.println(i);

        int i = 20;
        while (i >= 7) {
            System.out.println(i);
            i--;
        }
    }
}