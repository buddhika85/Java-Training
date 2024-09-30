import java.util.ArrayList;
import java.util.Random;

public class Printer
{
    private String name;
    private int numOfSheets;
    private boolean isColor;
    private boolean isDoubleSided;

    ArrayList<PrintJob> jobQueue = new ArrayList<>();

    public Printer(String name, int numOfSheets, 
        boolean isColor, boolean isDoubleSided) 
    {
        this.name = name;
        this.numOfSheets = numOfSheets;
        this.isColor = isColor;
        this.isDoubleSided = isDoubleSided;
    }

    // TA - Q1
    public void print(int numOfSheetsNeeded)
    {
        if (numOfSheetsNeeded > numOfSheets)
        {
            System.out.println("Error - not enough sheets");
            return;
        }

        numOfSheets -= numOfSheetsNeeded;
        System.out.println("Success - Print success");
    }

    public void restock(int sheets)
    {
        numOfSheets += sheets;
    }


    public void printJob(PrintJob job)
    {
        jobQueue.add(job);
        System.out.println("ADDED " + job.nameOfFile + " to the queue. It's in position: " + jobQueue.size());
        printMultipleJobs();
    }

    public void printMultipleJobs()
    {
        if (jobQueue.isEmpty())
        {
            System.out.println("No print jobs in the queue");
            return;
        }

        // 0,1 or 2
        int randomJobCount = new Random().nextInt(jobQueue.size() + 2);       // 0 (inclusive) to exclusive upper bound
        if (randomJobCount == 0)
        {
            System.out.println("Busy... (" + jobQueue.size() + " jobs in the queue)");
            return;
        }

        while(randomJobCount > 0 && !jobQueue.isEmpty())
        {
            // FIFO - take 0th index job, oldest
            PrintJob oldest = jobQueue.remove(0);
            System.out.println("PRINTING: " + oldest);
            --randomJobCount;
        }        
    }


    @Override
    public String toString() {
        return "Printer [name=" + name + ", numOfSheets=" + numOfSheets + 
            ", isColor=" + isColor + ", isDoubleSided="
                + isDoubleSided + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSheets() {
        return numOfSheets;
    }

    public void setNumOfSheets(int numOfSheets) {
        this.numOfSheets = numOfSheets;
    }

    public boolean isColor() {
        return isColor;
    }

    public void setColor(boolean isColor) {
        this.isColor = isColor;
    }

    public boolean isDoubleSided() {
        return isDoubleSided;
    }

    public void setDoubleSided(boolean isDoubleSided) {
        this.isDoubleSided = isDoubleSided;
    }
}