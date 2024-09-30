public class PrintJob 
{
    String nameOfFile;
    int numOfCopies;
    boolean isPortrait;             // will be false if landscape
    String content;

    public PrintJob(String nameOfFile, int numOfCopies, boolean isPortrait, String content) 
    {
        this.nameOfFile = nameOfFile;
        this.numOfCopies = numOfCopies;
        this.isPortrait = isPortrait;
        this.content = content;
    }

    @Override
    public String toString() 
    {
        return "Name: " + nameOfFile + ", content: " + content;
    }    
}