public class Test 
{
    public static void main(String[] args) 
    {
        Printer printer = 
            new Printer("Lab Printer", 100, true, false);
        // System.out.println(printer);
        // printer.print(101);

        // printer.print(50);
        // System.out.println(printer);


        // TA - last part TA
        printer.printJob(new PrintJob("One.Pdf", 1, true, "This is doc 1"));
        printer.printJob(new PrintJob("Two.Pdf", 1, true, "This is doc 2"));
        printer.printJob(new PrintJob("Three.Pdf", 1, true, "This is doc 3"));
        printer.printJob(new PrintJob("Four.Pdf", 1, true, "This is doc 4"));
    }
}
