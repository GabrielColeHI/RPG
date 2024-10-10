public class Shapeshifter extends Character{
    public Shapeshifter(String n, int s, int d){
        super(s, d, n);
    }
    public void attack(Character opp) {
        super.attack(opp);
        if(Math.random() < 0.3) {
//can change shape, assign points to def, strength, etc, basically build a bear for a character
        }


    }
}
