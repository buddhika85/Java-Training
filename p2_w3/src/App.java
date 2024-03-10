public class App {
    public static void main(String[] args) throws Exception 
    {
        System.out.println("week3");
        testSquad();
    }

    private static void testSquad() 
    {
        Squad squad = new Squad();
        squad.addSoldier(new Marine());
        squad.addSoldier(new Firebat());
        squad.addSoldier(new Marine());
        squad.addSoldier(new Marine());
        squad.addSoldier(new Firebat());
        squad.addSoldier(new Firebat());
        squad.addSoldier(new Firebat());
        squad.addSoldier(new Marine());

        squad.addSoldier(new Ghost());
        squad.addSoldier(new Ghost());

        squad.printSquadComposition();
    }
}
