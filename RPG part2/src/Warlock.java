public class Warlock extends Character{
    public Warlock(String n){
        super(10, 20, n);
    }
    public void attack(Character opp) {
        super.attack(opp);
        if (Math.random() < 0.3) {
            setHealth(getHealth() + 2);//Steals Life
        }
    }
        public void specialAttack(Character opp){

            if (Math.random() < 0.3) {
            opp.setDebuff("Blindness");
            }
           else  if (Math.random() < 0.6) {
                opp.setDebuff("Weakness");
            }
            else  {
                System.out.println("Failed");
                }




    }
}
