import java.util.ArrayList;

public class Item {
    String name;
    int pAtk=0, mAtk=0, pDef=0, mDef=0;
    //attack and defense stats of each item that will be added to the base stats of a player
    int speedB=0, strengthB=0, magicB=0;
    //bonus stats that can boost the ability level of a player
    int speedR=0, strengthR=0, magicR=0;
    //requirement stats for items
    ArrayList<String> moves = new ArrayList<String>();
    String description = "";
    String type;
    //these will be string names for every type of each item i.e. Sword, Spear, Dagger, etc for weapons and ring, scroll, etc for accessories
    //these names will be used for classification in game and correlation with to be made character classes(knight and mage stuff) and also game balance as all Items of each type should share certain qualities
    // all item csv files should be formatted in rows of name,pAtk,mAtk,pDef,mDef,speedB,strengthB,magicB,speedR,strengthR,magicR,type,description,any special attack
    // that is how the files are read and if you change that let me know
    void display()
    {
        boolean hasAtkDef=false;
        boolean hasStatsB=false;
        boolean hasStatsR=false;
        ArrayList<Integer> statsAD=new ArrayList<Integer>();
        statsAD.add(pAtk);statsAD.add(mAtk);statsAD.add(pDef);statsAD.add(mDef);
        ArrayList<Integer> statsB=new ArrayList<Integer>();
        statsB.add(speedB);statsB.add(strengthB);statsB.add(magicB);
        ArrayList<Integer> statsR=new ArrayList<Integer>();
        statsR.add(speedR);statsR.add(strengthR);statsR.add(magicR);
        for (int i: statsAD) {
            if(i!=0)
                hasAtkDef=true;
        }
        for (int i: statsB) {
            if(i!=0)
                hasStatsB=true;
        }
        for (int i: statsR) {
            if(i!=0)
                hasStatsR=true;
        }
        if(hasAtkDef)
        {
            System.out.print("Attack and Defense: |");
            if(statsAD.get(0)!=0)
            {
                System.out.print(" pAtk: "+pAtk+" |");
            }
            if(statsAD.get(1)!=0)
            {
                System.out.print(" mAtk: "+mAtk+" |");
            }
            if(statsAD.get(2)!=0)
            {
                System.out.print(" pDef: "+pDef+" |");
            }
            if(statsAD.get(3)!=0)
            {
                System.out.print(" mDef: "+mDef+" |");
            }
            System.out.println();
        }
        if(hasStatsB)
        {
            System.out.print("Secondary Stats: |");
            if(statsB.get(0)!=0)
            {
                System.out.print(" Speed: "+speedB+" |");
            }
            if(statsB.get(1)!=0)
            {
                System.out.print(" Strength: "+strengthB+" |");
            }
            if(statsB.get(2)!=0)
            {
                System.out.print(" Magic: "+magicB+" |");
            }
            System.out.println();
        }
        if(hasStatsR)
        {
            System.out.print("Requirements: |");
            if(statsR.get(0)!=0)
            {
                System.out.print(" Speed: "+speedR+" |");
            }
            if(statsR.get(1)!=0)
            {
                System.out.print(" Strength: "+strengthR+" |");
            }
            if(statsR.get(2)!=0)
            {
                System.out.print(" Magic: "+magicR+" |");
            }
            System.out.println();
        }
        if("".equals(description))
        {

        }else{
            System.out.println("description");
        }
    }
    //display non-zero item stats

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getpAtk() {
        return pAtk;
    }
    public int getpDef() {
        return pDef;
    }
    public int getmAtk() {
        return mAtk;
    }
    public int getmDef() {
        return mDef;
    }
    public int getSpeedB() {
        return speedB;
    }
    public int getStrengthB() {
        return strengthB;
    }
    public int getMagicB() {
        return magicB;
    }
    public int getMagicR() {
        return magicR;
    }
    public int getSpeedR() {
        return speedR;
    }
    public int getStrengthR() {
        return strengthR;
    }
    public String getDescription() {
        return description;
    }

    //A forge system needs to be made so a player can craft and enhance their own items
    //bellow ive pasted the code from my old one thought it is now incomparable with new game variables and features
    // if you look at it focus on the general process of how the weapon is built and not the actual stats
    /*
    from main

    public static void enhance()
    {
        Item select;
        Material selectm;
        for(int i=0; i<kevin.getIV().size();i++)
        {
            System.out.print((i + 1) + ". " + kevin.getIV().get(i).getName() + " ");
            if(i%7==0&&i!=0)
                System.out.println();
            if(i==kevin.getIV().size()-1)
            {
                System.out.print((i + 2) + ". " + kevin.getaItem()[0].getName() + " ");
                System.out.print((i + 3) + ". " + kevin.getaItem()[1].getName() + " ");
                System.out.print((i + 4) + ". " + kevin.getaItem()[2].getName() + " ");
            }
        }
        System.out.println();
        System.out.println("Choose an Item to enhance");
        oop = keyboard.nextInt();
        while (oop > kevin.getIV().size()+3||oop<1) {
            if (oop == 999) {
                return;
            }
            if (oop==111||oop==1111) {
                itemGuide(kevin.getIV().get(keyboard.nextInt() - 1));
            }
            oop = keyboard.nextInt();
        }
        if(oop>kevin.getIV().size())
            select=kevin.getaItem()[oop-kevin.getIV().size()-1];
        else{
            select=kevin.getIV().get(oop-1);
        }
        System.out.println("Choose a material");
        for(int i=0; i<kevin.getMV().size();i++) {
            System.out.print((i + 1) + ". " + kevin.getMV().get(i).getName() + " ");
            if (i % 7 == 0 && i != 0)
                System.out.println();
        }
        poo = keyboard.nextInt();
        while (poo > kevin.getMV().size()||poo<1) {
            if (poo == 999) {
                return;
            }
            if (poo==111||poo==1111) {
                matGuide(kevin.getMV().get(keyboard.nextInt() - 1));
            }
            if(poo==3333) {
                pooo=keyboard.nextLine();
                pooo=keyboard.nextLine();
                for(int y=0;y<kevin.getMV().size();y++)
                {
                    kevin.remMat(pooo);
                }
            }
            poo = keyboard.nextInt();
        }
        selectm=kevin.getMV().get(poo-1);
        System.out.println("Choose a slot for the material");
        for (int i = 0; i < select.getMats().length; i++) {
            System.out.print((i + 1) + ". " + select.getMats()[i].getName() + " ");
        }
        opo = keyboard.nextInt();
        while (opo > select.getMats().length||opo<1) {
            if (opo == 999) {
                return;
            }
            opo = keyboard.nextInt();
        }
        select.setMat(selectm,opo);
        if(oop>kevin.getIV().size())
            kevin.ItoA(select,oop-kevin.getIV().size());
        else{
            kevin.ToVault(select);
            kevin.remIt(oop);
        }
        kevin.remMat(poo);

    }
    public static void create(){
        int type;
        String name="";
        Material one;
        Material two;
        Material three;
        System.out.println("Choose a type for the item");
        ArrayList<String> types = new ArrayList<String>();
        types.add("Sword");
        types.add("Heavy Weapon");
        types.add("Magic Item");
        types.add("Dagger");
        types.add("Shield");
        types.add("Armor");
        printMoves(types);
        oop = keyboard.nextInt();
        while (oop > types.size()) {
            if (oop == 999) {
                return;
            }
            oop = keyboard.nextInt();
        }
        type=oop;
        System.out.println("Choose primary material");
        for(int i=0; i<kevin.getMV().size();i++) {
            System.out.print((i + 1) + ". " + kevin.getMV().get(i).getName() + " ");
            if (i % 7 == 0 && i != 0)
                System.out.println();
        }
        poo = keyboard.nextInt();
        while (poo > kevin.getMV().size()||poo<1) {
            if (poo == 999) {
                return;
            }
            if (poo==111||poo==1111) {
                matGuide(kevin.getMV().get(keyboard.nextInt() - 1));
            }
            if(poo==3333)
            {
                pooo=keyboard.nextLine();
                pooo=keyboard.nextLine();
                for(int y=0;y<kevin.getMV().size();y++)
                {
                    kevin.remMat(pooo);
                }
            }
            poo = keyboard.nextInt();
        }
        one=kevin.getMV().get(poo-1);
        kevin.remMat(poo);
        System.out.println("Choose secondary material");
        for(int i=0; i<kevin.getMV().size();i++) {
            System.out.print((i + 1) + ". " + kevin.getMV().get(i).getName() + " ");
            if (i % 7 == 0 && i != 0)
                System.out.println();
        }
        poo = keyboard.nextInt();
        while (poo > kevin.getMV().size()||poo<1) {
            if (poo == 999) {
                return;
            }
            if (oop==111||poo==1111) {
                matGuide(kevin.getMV().get(keyboard.nextInt() - 1));
            }
            if(poo==3333)
            {
                pooo=keyboard.nextLine();
                pooo=keyboard.nextLine();
                for(int y=0;y<kevin.getMV().size();y++)
                {
                    kevin.remMat(pooo);
                }
            }
            poo = keyboard.nextInt();
        }
        two=kevin.getMV().get(poo-1);
        kevin.remMat(poo);
        System.out.println("Choose tertiary material");
        for(int i=0; i<kevin.getMV().size();i++) {
            System.out.print((i + 1) + ". " + kevin.getMV().get(i).getName() + " ");
            if (i % 7 == 0 && i != 0)
                System.out.println();
        }
        poo = keyboard.nextInt();
        while (poo > kevin.getMV().size()||poo<1) {
            if (poo == 999) {
                return;
            }
            if (oop==111||poo==1111) {
                matGuide(kevin.getMV().get(keyboard.nextInt() - 1));
            }
            if(poo==3333)
            {
                pooo=keyboard.nextLine();
                pooo=keyboard.nextLine();
                for(int y=0;y<kevin.getMV().size();y++)
                {
                    kevin.remMat(pooo);
                }
            }
            poo = keyboard.nextInt();
        }
        three=kevin.getMV().get(poo-1);
        kevin.remMat(poo);
        System.out.println("Choose a name for your item");
        name=keyboard.nextLine();
        name=keyboard.nextLine();
        Item i = new Item(one,two,three,type,name);
        kevin.IToVault(i);
    }
     */
    // variables like oop poo and opo are just scanner inputs that i had to save and reuse in some cases
    /*
    from Item class

    public Item(Material a, Material b, Material c, int t, String n)
    {
        expcap=10;
        name = n;
        level=1;
        type=t;
        rarity="Custom";
        element=a.getElement();
        comp[0]=a;
        comp[1]=b;
        comp[2]=c;
        baseStat();
        attacks();
    }

    public void baseStat()
    {
        String hehe="";
        atkPow=0;
        damageResist=0;
        healthBuff=0;
        speed=0;
        if("Custom".equals(rarity))
        {
            hehe=name;
        }
        if("Legendary".equals(rarity))
        {

        }else if(type==1)
        {
            atkPow=40*level;
            speed = 50*level;
            name=element+" Sword";
        }else if(type==2)
        {
            atkPow=60*level;
            damageResist=-10*level;
            speed = 30*level;
            name=element+" Blade";
        }else if(type==3)
        {
            atkPow=35*level;
            speed = 50*level;
            name=element+" Staff";
        }else if(type==4)
        {
            atkPow=35*level;
            speed=60*level;
            name=element+" Dagger";
        }else if(type==5)
        {
            damageResist=40*level;
            name=element+" Shield";
            speed=40*level;
        }else if(type==6)
        {
            damageResist=20*level;
            healthBuff=50*level;
            speed=50*level;
            name=element+" Armor";
        }
        if("Custom".equals(rarity))
        {
            compStat();
            name=hehe;
        }
        if("Legendary".equals(rarity))
        {

        }else {
            for (int i = 0; i < materials.length; i++) {
                if (materials[i] != null)
                    addStat(materials[i]);
            }
        }

    }
    public void attacks()
    {
        if(type==1)
        {
            if("Fire".equals(element))
            {
                moves.add("Flame Slash");
                if("Light".equals(element1))
                {
                    moves.add("Luminous Flame Strike");
                }else if("Dark".equals(element1))
                {
                    moves.add("Black Fire Blade");
                }
            }else if("Ice".equals(element))
            {
                moves.add("Ice Slice");
                if("Light".equals(element1))
                {
                    moves.add("White Ice Slice");
                }else if("Dark".equals(element1))
                {
                    moves.add("Umbra Ice Strike");
                }
            }else if("Lightning".equals(element)) {
                moves.add("Lightning Slice");
                if ("Light".equals(element1)) {
                    moves.add("White Thunder Strike");
                } else if ("Dark".equals(element1)) {
                    moves.add("Onyx Lightning Blade");
                }
            }else if("Light".equals(element))
            {
                moves.add("Luminous Slash");
                if("Light".equals(element1))
                {
                    moves.add("Holy Blade");
                }else if("Dark".equals(element1))
                {
                    moves.add("Luminous Shadow Strike");
                }
            }else if("Dark".equals(element))
            {
                moves.add("Shadow Slash");
                if("Light".equals(element1))
                {
                    moves.add("White Shadow Slash");
                }else if("Dark".equals(element1))
                {
                    moves.add("Black Umbra Blade");
                }
            }else if("None".equals(element))
            {
                moves.add("Strike");
                moves.add("Slash");
            }else if("All".equals(element))
            {
                moves.add("Luminous Flame Strike");
                moves.add("Umbra Lightning Slash");
                moves.add("Black Ice Blade");
            }
        }
        if(type==2)
        {
            if("Fire".equals(element))
            {
                moves.add("Flame Slash");
                if("Light".equals(element1))
                {
                    moves.add("Holy Flame Slash");
                }else if("Dark".equals(element1))
                {
                    moves.add("Dark Flame Strike");
                }
            }else if("Ice".equals(element))
            {
                moves.add("Freeze Slash");
                if("Light".equals(element1))
                {
                    moves.add("White Ice Slash");
                }else if("Dark".equals(element1))
                {
                    moves.add("Black Cryo Strike");
                }
            }else if("Lightning".equals(element))
            {
                moves.add("Thunder Slash");
                if("Light".equals(element1))
                {
                    moves.add("White Lightning Slash");
                }else if("Dark".equals(element1))
                {
                    moves.add("Dark Thunder Blade");
                }
            }else if("Light".equals(element))
            {
                moves.add("Luminous Slash");
                if("Light".equals(element1))
                {
                    moves.add("Holy Slash");
                }else if("Dark".equals(element1))
                {
                    moves.add("Dark Light Strike");
                }
            }else if("Dark".equals(element))
            {
                moves.add("Shadow Slash");
                if("Light".equals(element1))
                {
                    moves.add("Holy Slash");
                }
            }else if("None".equals(element))
            {
                moves.add("Slash");
            }else if("All".equals(element))
            {
                moves.add("Holy Ice Slash");
                moves.add("Umbra Flame Slash");
                moves.add("Lightning Flame Blade");
            }
        }
        if(type==3)
        {
            if("Fire".equals(element))
            {
                moves.add("Incendiary Beam");
                if("Light".equals(element1))
                {
                    moves.add("Holy Fire Ball");
                }else if("Dark".equals(element1))
                {
                    moves.add("Dark Pyro Beam");
                }
            }else if("Ice".equals(element))
            {
                moves.add("Frost Ball");
                if("Light".equals(element1))
                {
                    moves.add("Light Cryo Beam");
                }else if("Dark".equals(element1))
                {
                    moves.add("Umbra Cryo Beam");
                }
            }else if("Lightning".equals(element))
            {
                moves.add("Lightning Ball");
                if("Light".equals(element1))
                {
                    moves.add("White Lightning Strike");
                }else if("Dark".equals(element1))
                {
                    moves.add("Black Thunder Strike");
                }
            }else if("Light".equals(element))
            {
                moves.add("Illuminating Beam");
            }else if("Dark".equals(element))
            {
                moves.add("Shadow Beam");
            }else if("None".equals(element))
            {

            }else if("All".equals(element))
            {
                moves.add("Luminous Fire Ball");
                moves.add("Umbra Lightning Beam");
                moves.add("Black Ice Control");
            }

        }
        if(type==4)
        {
            if("Fire".equals(element))
            {
                moves.add("Incendiary Blade");
                if("Light".equals(element1))
                {
                    moves.add("Holy Flame Stab");
                }else if("Dark".equals(element1))
                {
                    moves.add("Dark Pyro Slice");
                }
            }else if("Ice".equals(element))
            {
                moves.add("Cryo Stab");
                if("Light".equals(element1))
                {
                    moves.add("Holy Frost Pierce");
                }else if("Dark".equals(element1))
                {
                    moves.add("Dark Ice Slice");
                }
            }else if("Lightning".equals(element))
            {
                moves.add("Thunder Blades");
                if("Light".equals(element1))
                {
                    moves.add("Holy Lightning Slice");
                }else if("Dark".equals(element1))
                {
                    moves.add("Onyx Lightning Blade");
                }
            }else if("Light".equals(element))
            {
                moves.add("Lumina Blade");
                if("Light".equals(element1))
                {
                    moves.add("Holy Vortex");
                }else if("Dark".equals(element1))
                {
                    moves.add("Dark Vortex");
                }
            }else if("Dark".equals(element))
            {
                moves.add("Umbra Vortex");
                if("Light".equals(element1))
                {
                    moves.add("White Black Slash");
                }else if("Dark".equals(element1))
                {
                    moves.add("Dark Black Slice");
                }
            }else if("None".equals(element))
            {
                moves.add("Stab");
                moves.add("Pierce");
            }else if("All".equals(element))
            {
                moves.add("Luminous Lightning Blades");
                moves.add("Black Flame Slash");
                moves.add("Ice Fire Pierce");
            }
        }

    }
       public void compStat()
    {
        addStat(comp[0]);
        addStat(comp[1]);
        addStat(comp[2]);
    }
     */
}
