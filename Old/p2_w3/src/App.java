public class App {
    public static void main(String[] args) throws Exception 
    {
        System.out.println("week3");
        testSquad();
    }

    private static void testSquad() 
    {
        Squad squad = new Squad();
        squad.add(new Marine());
        squad.add(new Firebat());
        squad.add(new Marine());
        squad.add(new Marine());
        squad.add(new Firebat());
        squad.add(new Firebat());
        squad.add(new Firebat());
        squad.add(new Marine());

        squad.add(new Ghost());
        squad.add(new Ghost());

        squad.add(new Wraith());
        squad.add(new Wraith());
        squad.add(new Wraith());
        squad.add(new Wraith());

        squad.printSquadComposition();
    }
}
