public class App {
    public static void main(String[] args)
    {
        // Printer printer = new Printer("Lab Printer", 5, true, true);
        // System.out.println(printer);
        // printer.print(6);       // not enough
        // printer.print(1);
        // System.out.println(printer);

        Printer printer = new Printer("Lab Printer", 100, true, true);
        printer.printJob(new PrintJob("Volume 1.pdf", 10, 2, false, "Volume 1...."));
        printer.printJob(new PrintJob("Volume 2.pdf", 10, 1, true, "Volume 2...."));
        printer.printJob(new PrintJob("Volume 3.pdf", 10, 7, true, "Volume 3...."));
        printer.printJob(new PrintJob("Volume 4.pdf", 1, 1, true, "Volume 4...."));
       

        System.out.println("\n" + printer + "\n");
    }
}