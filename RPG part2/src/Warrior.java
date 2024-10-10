public class Warrior extends Character{
    public Warrior(String n){
        super(20, 10, n);
    }

    public void attack(Character opp) {
        setSub("Warrior");
        int first = opp.getHealth();
        super.attack(opp);

        if(Math.random() < 0.3) {
            opp.setHealth(opp.getHealth() - 5);
            System.out.println("Extra damage done! You dealt 5 more damage.");
        }
            System.out.println("You hit them for " +  (first - opp.getHealth()));




    }
}
