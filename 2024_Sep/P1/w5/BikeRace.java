public class BikeRace 
{
    String eventName;           //, a string.
    Cyclist[] participants;     //, an array of Cyclist objects.
    int nextToRegister;          // will serve as an index to register a racer to the event.

    BikeRace(String eventName, int numberRacers)
    {
        this.eventName = eventName;
        this.participants = new Cyclist[numberRacers];
        this.nextToRegister = 0;        // initially nobody is registered
    }

    void registerCyclist(String name, double endurance, double sprint, double preparation)
    {
        if (nextToRegister >= participants.length)
        {
            System.out.println("Error - race is already with full number of participants");
        }
        else
        {            
            participants[nextToRegister] = new Cyclist(name, endurance, sprint, preparation);
            ++nextToRegister;
            System.out.println("Success: " + name + " got registered.");
        }
    }

    void printDetails()
    {
        System.out.println("Race event:" + this.eventName);
        System.out.println("Participants:");

        // Need to be careful not to print null elements.
        // Thats why used nextToRegister in the loop condition
        for (int i = 0; i < this.nextToRegister; i++) 
        {
            // Need to be careful not to print null elements.
            System.out.println(this.participants[i]);
            
        }
    }

    void userRegistration() 
    {
        System.out.println("REGISTER CYCLIST" );
        System.out.println("----------------");

        if (nextToRegister >= this.participants.length) 
        {
            System.out.println("Race is full!");
        } 
        else 
        {
            System.out.print("Enter name: ");
            String name = In.nextLine();

            System.out.print("Enter endurance ability: ");
            double endurance = In.nextDouble();

            System.out.print("Enter sprint ability: ");
            double sprint = In.nextDouble();

            System.out.print("Enter preparation: ");
            double preparation = In.nextDouble();

            Cyclist cyclist = new Cyclist(name, endurance, sprint, preparation);
            this.participants[this.nextToRegister] = cyclist;

            System.out.println(name + " is now a registered participant of this race.");
            this.nextToRegister++;
        }
    }

    public static void main(String[] args) 
    {
        BikeRace race = new BikeRace("Sydney racers", 5);
        race.registerCyclist("Jack", 80, 70, 80);
        race.registerCyclist("Jill", 70, 75, 85);
        race.userRegistration();
        race.printDetails();
    }
}
