import java.util.ArrayList;
import java.util.Random;

public class Printer
{
    private static final Random random = new Random();
    private String name;
    private int numOfSheets;
    private boolean isColorPrinter;   
    private boolean isDoubleSided;
    private ArrayList<PrintJob> jobQueue = new ArrayList<>();

    public Printer(String name, int numOfSheets, boolean isColorPrinter, boolean isDoubleSided) {
        setName(name);
        setNumOfSheets(numOfSheets);
        setColorPrinter(isColorPrinter);
        setDoubleSided(isDoubleSided);
    }

    public String getName() {
        return name;
    }
    public int getNumOfSheets() {
        return numOfSheets;
    }
    public boolean isColorPrinter() {
        return isColorPrinter;
    }  
    public boolean isDoubleSided() {
        return isDoubleSided;
    }

    public void setName(String name) {
        this.name = name;
    }  
    public void setNumOfSheets(int numOfSheets) {
        this.numOfSheets = numOfSheets;
    } 
    public void setColorPrinter(boolean isColorPrinter) {
        this.isColorPrinter = isColorPrinter;
    }
    public void setDoubleSided(boolean isDoubleSided) {
        this.isDoubleSided = isDoubleSided;
    }

    
    // public void print(int numOfPages)
    // {
    //     if (numOfSheets >= numOfPages)
    //     {
    //         System.out.println("Document Printed");
    //         numOfSheets -= numOfPages;
    //     }
    //     else
    //     {
    //         System.out.println("Printer out papers!!!\n You need " 
    //             + numOfPages + " and printere has only " + numOfSheets);
    //     }
    // }

    public void enque(PrintJob job)
    {
        jobQueue.add(job);
        System.out.println("Added '" + job.getNameOfFile() + "' to the queue.");
    }

    public void dequeue()
    {
        // FIFO
        jobQueue.remove(0);
    }

    // job is to randomly select a number of jobs from the queue to print.
    public void printMultipleJobs()
    {
        int jobCount = generateJobCount(0, 2);
        if (jobCount == 0)
        {
            // if the number drawn is 0, print a message indicating that the printer is busy and report the number of jobs remaining in the queue.
            System.out.println("Busy... (" + jobQueue.size() + " in the queue)" + "\n");
        }
        else
        {
            boolean hasEnoughPapers = true;
            while(hasEnoughPapers && jobCount > 0 && jobQueue.size() > 0)
            {
                var firstInQueue = jobQueue.get(0);
                var totalPagesNeeded = firstInQueue.getNumOfPages() * firstInQueue.getNumOfCopies();
                if (totalPagesNeeded <= numOfSheets)
                {
                    System.out.println("PRINTING: Name: " + firstInQueue.getNameOfFile() + ", content: " + firstInQueue.getContent() + "\n");
                    numOfSheets -= totalPagesNeeded;
                    dequeue();
                    --jobCount;
                }
                else
                {
                    hasEnoughPapers = false;
                    System.out.println("Warning: Restock papers !!! - Printer has: " + numOfSheets + ", job needs: " + totalPagesNeeded + "\n");
                }   
            }
        }
    }

    public void printJob(PrintJob job)
    {
        enque(job);
        printMultipleJobs();
    }

    public void restock(int restockCount)
    {
        numOfSheets += restockCount;
    }

    private int generateJobCount(int lower, int upper)
    {
        return random.nextInt(lower, upper + 1);      // exclusive end
    }

    @Override
    public String toString()
    {
        return "Printer: " + name + " Sheets: " + numOfSheets 
            + " Is Color Printer: " + isColorPrinter 
            + " Is Double Sided: " + isDoubleSided
            + " Job count in queue: " + jobQueue.size();
    }
}