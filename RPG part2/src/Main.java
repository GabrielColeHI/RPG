import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Character test = new Warrior("Dave");
        Character opp = new Sumo("AdamHUGE");
        Character war = new Warrior("test");
        System.out.println( war.getInfo());
        System.out.println( opp.getInfo());

       // test.attack(opp);
        battle();
    }

    public static int choice(Character test){
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        System.out.println("What would you like to do?");
        System.out.println("1) Attack");
        System.out.println("2) Defend");
        try {
             choice = Integer.parseInt(sc.nextLine());
        } catch (Exception e){
            System.out.println("oops");
        }

        return choice;

    }

    public static void battle(){

        int battle = -1;
        int win = 0;
        int loss = 0;
        int battlecount = 0;
        int h = 0;
        int level = 1;

        System.out.println("Pick Your Character!)");
        System.out.println("1) Warrior");
        System.out.println("2) Sumo");
        System.out.println("3) Warlock");
        System.out.println("4) Shape shifter");


        Scanner sc = new Scanner(System.in);
        int choice = -1;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (Exception e){
            System.out.println("oops");
        }
        System.out.println(choice);

        Character p = new Warrior("default");

        if(choice == 1){
         p = new Warrior("Player");
        }
        else  if(choice == 2){
            p = new Sumo("Player");

        }
        else  if(choice == 3){
            p = new Warlock("Player");

        }
        else  if(choice == 4){
            int num = 15;
            Scanner sc1 = new Scanner(System.in);
            System.out.println("You have 35 points to use, how many would you like to spend on strength?(The remainder will go to defense");
            try {
                 num = Integer.parseInt(sc.nextLine());
            } catch (Exception e){
                System.out.println("oops");
            }

            p = new Shapeshifter("Player", num, 35-num );

        }



        Character opp = new Character(10, 10, "Newbie");


        while(battle < 0) {
            if(level == 1){
                 opp = new Character(10, 10, "Newbie");
            }


            if(p.getHealth() > 0 && opp.getHealth()>0){
             h = choice(p);
                if(h == 1){
                    p.attack(opp);
                }
                if(h == 2){
                    p.defend();

                }

            }

            if (p.getHealth() <= 0 && opp.getHealth() >0){
                battle++;
                System.out.println("L");
            }
            if(opp.getHealth() > 0 && p.getHealth() >= 0){
                opp.attack(p);
                System.out.println("hit u");

            }
            else if(opp.getHealth() <=0){
                System.out.println("W");
                level++;
                p.setHealth(20);
                if(level == 2){
                    opp = new Character(10, 15, "Knight");
                    opp.setHealth(20);

                }
                if(level == 3){
                    opp = new Character(15, 15, "General");
                    opp.setHealth(20);

                }
                if(level == 4){
                    opp = new Character(15, 20, "Commander");
                    opp.setHealth(20);

                }
                if(level == 5){
                    opp = new Character(20, 30, "Grandmaster");
                    opp.setHealth(20);
                }

            }

            if(level ==6){
                battle++;
                p.setDefStatus(false);

            }
        }
    }




    public static void simulation(Character p,  Character opp, int battles){

        int[] pinfo = new int[4]; // Create an ArrayList object\
        int[] oppinfo = new int[4]; // Create an ArrayList object\
        pinfo[0] = p.getHealth();
        oppinfo[0] = opp.getHealth();

        //saves info
        int win = 0;
        int loss = 0;
        int battlecount = 0;
        while(battlecount < battles) {
           int battle = -1;
            while(battle < 0) {


                if(p.getHealth() > 0 && opp.getHealth()>0){
                    p.attack(opp);
                }


            else if (p.getHealth() <= 0 && opp.getHealth() >0){
                loss++;
                System.out.println("L");
                p.setHealth(pinfo[0]);
                opp.setHealth(oppinfo[0]);
                battle++;
            }
            if(opp.getHealth() > 0 && p.getHealth() <= 0){
                opp.attack(p);

            }
            else if(opp.getHealth() <=0 && p.getHealth() >0){
                System.out.println("W");
                win++;
                p.setHealth(pinfo[0]);
                opp.setHealth(oppinfo[0]);
                battle++;

            }
        }
            battlecount++;
        }
        System.out.println("Won: "+ win + ", lost: "+ loss + ", battles: "+ battlecount);
    }
}