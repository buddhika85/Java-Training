public class PrintJob 
{
    private String nameOfFile;    
    private int numOfPages;    
    private int numOfCopies;   
    private boolean isPortrait;

    private String content;

    public PrintJob(String nameOfFile, int numOfPages, int numOfCopies, boolean isPortrait, String content) {
        this.nameOfFile = nameOfFile;
        this.numOfPages = numOfPages;
        this.numOfCopies = numOfCopies;
        this.isPortrait = isPortrait;
        this.content = content;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public String getContent() {
        return content;
    }
    
    public int getNumOfPages() {
        return numOfPages;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    
    @Override
    public String toString()
    {
        return "Print Job " + nameOfFile + " numOfCopies: " +  numOfCopies + " isPortrait: " + isPortrait;
    }
}
