import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception
    {
        //testBinarySearch();
        //testProperty();
        //testAgentInvetory();

        testMusicPlayer();
    }

    private static void testMusicPlayer() 
    {
        AudioTrack[] library = { new Song("Gangnam Style", 219, "Psy", MusicGenre.POP),
                new Song("Enter Sandman", 331, "Metallica", MusicGenre.METAL),
                new Podcast("The Joe Rogan Experience: Robert Kennedy, Jr", 10800, "Joe Rogan", PodcastGenre.COMEDY,
                        1999),
                new Song("Aces High", 271, "Iron Maiden", MusicGenre.METAL),
                new Podcast("The Joe Rogan Experience: Mike Tyson", 9000, "Joe Rogan", PodcastGenre.COMEDY,
                        1532),
                new Song("Moonshield", 301, "In Flames", MusicGenre.METAL),
                new Song("Mesmeric Horror", 314, "Inferi ", MusicGenre.METAL),
                new Song("Eye of the Tiger", 245, "Survivor", MusicGenre.ROCK),
                new Song("Beat It", 258, "Michael Jackson", MusicGenre.POP),
                new Song("Ode To Joy", 660, "Ludwig van Beethoven", MusicGenre.CLASSICAL),
                new Podcast("Lex Fridman Podcast: Mark Zuckerberg", 3840, "Lex Fridman", PodcastGenre.TECHNOLOGY,
                        398) };
        PlayList playList = PlayList.generateRandomPlayList(library.length, 3);
        new MusicPlayer(library, PlayMode.LINEAR).listenToPlayList(playList);
    }

    private static void testAgentInvetory() 
    {
        Property[] data = { 
            new Property(PropertyType.APARTMENT, 800, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1200, 400, 5, 5),

            new Property(PropertyType.APARTMENT, 800, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1400, 400, 7, 5),

            new Property(PropertyType.APARTMENT, 900, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1000, 300, 6, 5),
        };
        AgentInventory agentInventory = new AgentInventory();
        agentInventory.addForRent(data[0]);
        agentInventory.addForRent(data[1]);
        agentInventory.addForRent(data[2]);        
        agentInventory.addForSale(data[3]);
        agentInventory.addForSale(data[4]);
        agentInventory.addForSale(data[5]);

        List<Property> propertiesForRent = agentInventory.getPropertiesForRent();
        System.out.println("\nProperties For Rent - Price, Num of Rooms");
        displayAll(propertiesForRent);

        List<Property> propertiesForSale = agentInventory.getPropertiesForSale();
        System.out.println("\nProperties For Sale - Sorted");
        displayAll(propertiesForSale);
    }

    private static void testProperty() 
    {
        Property[] data = { 
            new Property(PropertyType.APARTMENT, 800, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1200, 400, 6, 5),

            new Property(PropertyType.APARTMENT, 800, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1400, 400, 7, 5),

            new Property(PropertyType.APARTMENT, 900, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1000, 300, 6, 5),
        };
        ArrayList<Property> properties = new ArrayList<>(Arrays.asList(data));
        System.out.println("Original");
        displayAll(properties);

        Collections.sort(properties, Property.PRICE_COMPARATOR_ASC);
        System.out.println("\nSort By Price - low to high");
        displayAll(properties);

        Collections.sort(properties, Property.PRICE_COMPARATOR_DESC);
        System.out.println("\nSort By Price - high to low");
        displayAll(properties);
    }

    private static void displayAll(List<Property> properties) 
    {
        for (Property property : properties) 
        {
            System.out.println("\t" + property);
        }
    }

    private static void testBinarySearch() {
        Integer[] ints = { 1, 3, 5, 6, 10, 200, 271, 340, 2000, 10000 };
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(ints));

        int value = 271;
        System.out.println(arrayList);
        int index = Collections.binarySearch(arrayList, value);
        System.out.println(value + " is at index " + index);
    }
}
