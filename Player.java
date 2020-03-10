import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    String name;
    int pAtk=0, mAtk=0, pDef=0, mDef=0;
    int speed=0, strength=0, magic=0;
    int health;
    int totalHealth;
    Weapon[] eqWep = new Weapon[1];
    Accessory[] eqAcc = new Accessory[1];
    Armor[] eqArmor = new Armor[1];
    //I defined these as arrays as I want them to be a vessel for the Item objects and not mess with the assigned memory spaces
    //Actually idk what im doing but ive already done a bunch so im not gonna change it
    Item[][] equipped = new Item[][]{eqWep,eqAcc,eqArmor};
    //2d array for a definite number of equipped items that cant be changed and also if needed we can print information with a loop referencing them all as Item objects
    ArrayList<String> moves = new ArrayList<String>();
    ArrayList<Weapon> weaValut = new ArrayList<Weapon>();
    ArrayList<Accessory> accValut = new ArrayList<Accessory>();
    ArrayList<Armor> armValut = new ArrayList<Armor>();
    private int gold;
    public Player() {
        Scanner keyboard = new Scanner(System.in);
        name = keyboard.nextLine();
        health = 100;
        gold=100;
        //reminder money system must exist
    }

    public void setEquipped(Weapon a, Accessory b, Armor c) {
        eqWep[0]=a;
        eqAcc[0]=b;
        eqArmor[0]=c;
    }
    // this takes a makes it so only one of each Item type to keep the specific slot assignments
    public void setEqWep(Weapon a) {
        eqWep[0]=a;
    }

    public void setEqAcc(Accessory a) {
        eqAcc[0]=a;
    }

    public void setEqArmor(Armor a) {
        eqArmor[0]=a;
    }
    // these three methods are to assign slots individually in the scenario of trying to switch one Item in your inventory
    public boolean checkReq(Item e){
        boolean equippable= true;
        if(e.getSpeedR()<speed){
            System.out.println("Speed stat too low");
            equippable=false;
        }
        if(e.getStrengthR()<strength){
            System.out.println("Strength stat too low");
            equippable=false;
        }
        if(e.getMagicR()<magic){
            System.out.println("Magic stat too low");
            equippable=false;
        }
        return equippable;
    }
    //used when equipping item in inventory in an if statement with the contents being on of the setItem methods
    public void checkReq()
    {
        boolean equippable=true;
        for (int i=0;i<3;i++){
            if(equipped[0][i].getSpeedR()<speed){
                System.out.println("Speed stat too low for "+equipped[0][i].getName());
                equippable=false;
            }
            if(equipped[0][i].getStrengthR()<strength){
                System.out.println("Strength stat too low for "+equipped[0][i].getName());
                equippable=false;
            }
            if(equipped[0][i].getMagicR()<magic) {
                System.out.println("Magic stat too low for "+equipped[0][i].getName());
                equippable = false;
            }
            if(!equippable) {
                if (i == 0) {
                    weaValut.add(eqWep[0]);
                    eqWep[0]=null;
                }else if (i == 1){
                    accValut.add(eqAcc[0]);
                    eqAcc[0]=null;
                }else if (i == 2){
                    armValut.add(eqArmor[0]);
                    eqArmor[0]=null;
                }
            }
        }
    }
    //to be used after you equip an item to verify that all stats are still high enough for every equipped item
}
