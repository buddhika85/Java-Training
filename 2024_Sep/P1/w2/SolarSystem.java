public class SolarSystem 
{
    public static void main(String[] args) 
    {        
        System.out.println("Please select a selectedPlanet:");
        
        System.out.println("1. Mercury");
        System.out.println("2. Venus");
        System.out.println("3. Earth");
        System.out.println("4. Mars");
        System.out.println("5. Jupiter");
        System.out.println("6. Saturn");
        System.out.println("7. Uranus");
        System.out.println("8. Neptune");

        int selection = In.nextInt();
        String selectedPlanet = "";

        if (selection == 1)
        {
            selectedPlanet = "Mercury";
        }
        else if (selection == 2)
        {
            selectedPlanet = "Venus";
        }
        else if (selection == 3)
        {
            selectedPlanet = "Earth";
        }
        else if (selection == 4)
        {
            selectedPlanet = "Mars";
        }
        else if (selection == 5)
        {
            selectedPlanet = "Jupiter";
        }
        else if (selection == 6)
        {
            selectedPlanet = "Saturn";
        }
        else if (selection == 7)
        {
            selectedPlanet = "Uranus";
        }
        else if (selection == 8)
        {
            selectedPlanet = "Neptune";
        }
        else
        {
            selectedPlanet = "Error - invalid selection";
        }

        System.out.println("You selected : " + selectedPlanet);

        ////// next part
        // mercury -> grey, 
        // venus -> yellow,  saturn -> yellow
        // mars -> red, jupiter -> red, 
        // earth -> blue, uranus -> blue, neptune -> blue
        String color = "";
        if (selectedPlanet.equals("Mercury"))
        {
            color = "Grey";
        }
        else if (selectedPlanet.equals("Venus") || selectedPlanet.equals("Saturn"))
        {
            color = "Yellow";
        }
        else if (selectedPlanet.equals("Mars") || selectedPlanet.equals("Jupiter"))
        {
            color = "Red";
        }
        else if (selectedPlanet.equals("Earth") || selectedPlanet.equals("Uranus") || selectedPlanet.equals("Neptune"))
        {
            color = "Blue";
        }

        if (!color.equals(""))
        {
            System.out.println(selectedPlanet + " is " + color);
        }
        else
        {
            System.out.println("Color unknown");
        }

        ////// next part
        if (selection % 2 == 0)
        {
            System.out.println("Your input is even");
        }
        else
        {
            System.out.println("Your input is odd");
        }
    }
}
