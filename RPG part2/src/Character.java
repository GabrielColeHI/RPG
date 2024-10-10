public class Character {
    private int strength;
    private int defense;
    private int health;
    private String name;
    private String subClass;
    private boolean defending;
    private String debuff;
    public Character(String name){

        int random = (int)(Math.random() * 30 + 1);


        this.strength = random;
        this.defense = 30-random;
        this.health = 20;
        this.name = name;
    }
    public Character(int s, int d,String n){
        this.strength = s;
        this.defense = d;
        this.name = n;
        this.health = 20;
    }
    public int getStrength(){
        return strength;
    }
    public int getHealth(){
        return health;
    }
    public String getInfo(){
        String info = "";
        info = name + "'s Stats:" +"\nStrength: " + strength + ". Defense: " + defense + ". Health: " + health;

        return info;
    }

    public void attack(Character opp){
        String name = opp.getName();
        if (opp instanceof Sumo) {
            if(Math.random() < 0.3) {
                opp.health = health + (opp.defense/2 - strength -3);
                System.out.println("The attack bounced back! " +name +" was brought down to "+ opp.health + "hp");
            }
        }


       else if(strength > opp.defense){
            opp.health = health + (opp.defense/2 - strength);
            System.out.println(name +" was hit! They got brought down to "+ opp.health + "hp");

         }
        else {
            opp.health = health -2;
            System.out.println(name +" was barely hit! They got brought down to "+ opp.health + "hp");

        }





    }

    public void specialAttack(Character opp) {
        String name = opp.getName();
        opp.health = health + (opp.defense/2 - strength) -6;

            if (Math.random() < 0.3) {
                opp.defense = defense-5;
                System.out.println("Uh oh, you just lost 5 defense for the next attack!");

        }
    }
    public void setHealth(int health){
        this.health =health;
    }
    public void setDefStatus(boolean def){
        defending = def;
    }
    public boolean getDefStatus(){
        return defending;
    }
    public int getDefense(){
        return this.defense;
    }
    public void setDebuff(String deb){
        debuff = deb;
    }
    public void defend(){
        setDefStatus(true);
        defense = defense + 15;
    }
    public void unDef(){
        defense = defense - 15;
    }
    public String getName(){
        return name;
    }
    public void setSub(String s){
        this.subClass = s;
    }
    public String getSubClass(){
    return subClass;
}}

