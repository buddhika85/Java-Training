public class PrintJob 
{
    private String fileName;
    private int numOfCopies;
    private int sheetsPerCopy;
    private boolean isPortrait;     // false = landscape
    private String content;

    public PrintJob(String fileName, int numOfCopies, 
        boolean isPortrait, int sheetsPerCopy, String content) {
        this.fileName = fileName;
        this.numOfCopies = numOfCopies;
        this.isPortrait = isPortrait;
        this.sheetsPerCopy = sheetsPerCopy;
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void setNumOfCopies(int numOfCopies) {
        this.numOfCopies = numOfCopies;
    }

    public int getSheetsPerCopy() {
        return sheetsPerCopy;
    }

    public void setSheetsPerCopy(int sheetsPerCopy) {
        this.sheetsPerCopy = sheetsPerCopy;
    }

    public boolean isPortrait() {
        return isPortrait;
    }

    public void setPortrait(boolean isPortrait) {
        this.isPortrait = isPortrait;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void print()
    {
        System.out.println("PRINTING Name: " + fileName + ", content: " + content);
    }

    @Override
    public String toString() {
        return "PrintJob fileName=" + fileName + ", numOfCopies=" + numOfCopies + ", sheetsPerCopy=" + sheetsPerCopy
                + ", isPortrait=" + isPortrait + ", content=" + content;
    }    
}