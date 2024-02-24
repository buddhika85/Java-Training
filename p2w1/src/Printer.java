public class Printer
{
    private String name;
    private int numOfSheets;
    private boolean isColorPrinter;
    private boolean isDoubleSided;

    public Printer(String name, int numOfSheets, boolean isColorPrinter, boolean isDoubleSided) {
        this.name = name;
        this.numOfSheets = numOfSheets;
        this.isColorPrinter = isColorPrinter;
        this.isDoubleSided = isDoubleSided;
    }

    public void print(int numOfPages)
    {
        if (numOfSheets >= numOfPages)
        {
            System.out.println("Document Printed");
            numOfSheets -= numOfPages;
        }
        else
        {
            System.out.println("Printer out papers!!!\n You need " 
                + numOfPages + " and printere has only " + numOfSheets);
        }
    }

    public void restock(int restockCount)
    {
        numOfSheets += restockCount;
    }

    @Override
    public String toString()
    {
        return "Printer: " + name + " Sheets: " + numOfSheets 
            + " Is Color Printer: " + isColorPrinter 
            + " Is Double Sided: " + isDoubleSided;
    }
}