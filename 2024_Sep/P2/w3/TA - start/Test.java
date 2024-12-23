public class Test 
{
    public static void main(String[] args) 
    {
        Squad squad = new Squad();
        squad.addSoldier(new Marine());
        squad.addSoldier(new Firebat());
        squad.addSoldier(new Firebat());


        // Exercise: Try modifying the above method by changing the type-cast of s from Marine to Firebat. Calling it, you will see that an exception will be thrown; what is its name?
        // Exception in thread "main" java.lang.ClassCastException: 
        // class Marine cannot be cast to class Firebat
        squad.activateStimpackForMarines();

        squad.printSquadComposition();
    }    
}
