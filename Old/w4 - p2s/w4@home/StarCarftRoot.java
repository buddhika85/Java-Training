public class StarCarftRoot {
    public static void main(String[] args) {
        Squad squad = new Squad();
        squad.addSoldier(new Marine());
        squad.addSoldier(new Firebat());
        squad.addSoldier(new Ghost());
        squad.addSoldier(new Ghost());
        squad.addSoldier(new Wraith());

      
        squad.activateStimpackForMarines();
        squad.printSquadComposition();
    }
}
