import java.util.ArrayList;
import java.util.Random;

public class Printer {
    
    private String name;
    private int sheetsRemaining;
    private boolean isColor;
    private boolean isDoubleSided;
    private ArrayList<PrintJob> jobQueue = new ArrayList<>();

    public Printer(String name, int sheetsRemaining, 
        boolean isColor, boolean isDoubleSided) {
        this.name = name;
        this.sheetsRemaining = sheetsRemaining;
        this.isColor = isColor;
        this.isDoubleSided = isDoubleSided;
    }

    public void print(int sheetsNeeded)
    {
        if (sheetsRemaining < sheetsNeeded)
        {
            System.out.println("Error - not enough sheets");
            return;     // not enough sheets
        }

        // enough sheets
        System.out.println("Print success");
        sheetsRemaining -= sheetsNeeded;
    }

    public void printMultipleJobs()
    {
        int numOfJobs = new Random().nextInt(3);    // generates 0,1,2 - exlusive upper bound
        if (numOfJobs == 0)
        {
            System.out.println("Printer Busy... Try later. Jobs remaining: " + jobQueue.size());
            return;
        }
        
        while(!jobQueue.isEmpty())
        {
            PrintJob job = jobQueue.get(0);
            int totalSheetsNeeded = job.getNumOfCopies() * job.getSheetsPerCopy();
            if (sheetsRemaining < totalSheetsNeeded)
            {
                System.out.println("No enough sheets to complete the job. Posponing for now.");
                return;
            }

            // enough sheets         
            sheetsRemaining -= totalSheetsNeeded;
            job.print();
            // remove from the queue
            jobQueue.remove(job);
        }      
    }

    public void addJob(PrintJob job)
    {
        jobQueue.add(job);  // adds to the end
        System.out.println("ADDED " + job.getFileName() + " to the queue. Your job is: " + jobQueue.size() + " in the queue");
    }

    public void printJob(PrintJob job)
    {
        addJob(job);
        printMultipleJobs();       
    }

    public void restock(int restockSheetCount)
    {
        sheetsRemaining += restockSheetCount;
        System.out.println("Sheets added");
    }

    @Override
    public String toString() 
    {
        return "Printer " + name + 
            ", sheetsRemaining =" + sheetsRemaining + 
            ", isColor=" + isColor
            + ", isDoubleSided=" + isDoubleSided;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSheetsRemaining() {
        return sheetsRemaining;
    }

    public void setSheetsRemaining(int sheetsRemaining) {
        this.sheetsRemaining = sheetsRemaining;
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
