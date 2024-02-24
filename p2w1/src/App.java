public class App {
    public static void main(String[] args) throws Exception 
    {
        Printer printer = new Printer("Lab Printer", 5, true, true);
        System.out.println(printer);

        printer.print(6);       // not enough

        printer.print(1);
        System.out.println(printer);
    }
}
