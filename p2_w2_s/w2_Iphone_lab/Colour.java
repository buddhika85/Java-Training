public enum Colour 
{
    Natural_Titanium("NaturalTitanium"),		
	Blue_Titanium("Blue Titanium"),
	White_Titanium("White Titanium"),
	Black_Titanium("Black Titanium");

    private String name;

    Colour(String name)
    {
        this.name = name;       
    }   

    public String getName() {
        return name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
