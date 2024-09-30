public enum BookStatus 
{
    AVAILABLE("Available"), BORROWED("Borrowed");
    
    private final String DISPLAY_STR;

    private BookStatus(String displayStr) 
    {
        DISPLAY_STR = displayStr;
    }

    public String toString()
    {
        return DISPLAY_STR;
    }
}
