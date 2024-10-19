public class Test 
{
    public static void main(String[] args) 
    {
        Squad squad = new Squad();
        squad.addSoldier(new Marine());
        squad.addSoldier(new Firebat());
        squad.addSoldier(new Firebat());
        squad.addSoldier(new Wraith());
        squad.addSoldier(new Wraith());
        squad.addSoldier(new Ghost());
        
        squad.activateStimpackForMarines();
        squad.cloakAllGhosts();

        System.out.println("Total ground power = " + squad.totalGroundAttackPower());
        squad.printSquadComposition();
    }    
}
