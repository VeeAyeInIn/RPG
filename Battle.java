import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
    Scanner keyboard = new Scanner(System.in);
    public int dam;
    ArrayList<String> moves = new ArrayList<String>();
    String enemyAttack = "";
    int turn;
    public Battle(Player kevin, Player enemy) throws IOException {
        printStats(enemy);
        System.out.println();
        printStats(kevin);
        turn=0;
        if(enemy.speed>kevin.speed)
            turn=1;
        while(kevin.health>0&&enemy.health>0)
        {
            if(turn%2==0){
                moves = kevin.moves;
                printMoves(moves);
                int move = keyboard.nextInt() - 1; // Current Move
                while ((move >= moves.size() && keyboard.hasNextInt())) {
                    if (move == 110) {
                        while (move >= moves.size() && keyboard.hasNextInt()) {
                            move = keyboard.nextInt() - 1;
                        }
                        //attackGuide(moves.get(move));
                    }
                    move = keyboard.nextInt() - 1;
                }
                attack(moves.get(move), kevin, enemy);
                if (dam < 0)
                    dam = 0;
                System.out.println(dam + " damage");
                enemy.health-=dam;
                printStats(enemy);
            }else if(turn%2==1)
            {
                moves = enemy.moves;
                if (moves.size() == 0)
                    moves.add("taunt");
                enemyAttack = moves.get((int) (Math.random() * moves.size()));
                System.out.println(enemy.name + " used " + enemyAttack);
                keyboard.next();
                attack(enemyAttack, enemy, kevin);
                if (dam < 0)
                    dam = 0;
                System.out.println(dam + " damage");
                kevin.health-=dam;
                printStats(kevin);
            }
            turn++;
        }
        if(kevin.health<=0)
        {
            System.out.println(" _____ ____  _      _____   ____  _     _____ ____ ");
            System.out.println("/  __//  _ \\/ \\__/|/  __/  /  _ \\/ \\ |\\/  __//  __\\");
            System.out.println("| |  _| / \\|| |\\/|||  \\    | / \\|| | //|  \\  |  \\/|");
            System.out.println("| |_//| |-||| |  |||  /_   | \\_/|| \\// |  /_ |    /");
            System.out.println("\\____\\\\_/ \\|\\_/  \\|\\____\\  \\____/\\__/  \\____\\\\_/\\_\\");
            System.exit(0);
        }else if(enemy.health<=0){
            //this was the logic on receiving an opponents weapon and armor after winning from an older game i.e. not the same variables or item system
            //but I think this should be ditched in favor of materials or gold being the primary post battle reward
            //though maybe item rewards can come from bosses
            /*kevin.changeHealth(kevin.getTHealth() / -4);
            if (kevin.getHealth() > kevin.getTHealth()) {
                kevin.resetHealth();
            }
            System.out.println();
            if (enemy.getMat() == null) {
                System.out.println("You have defeated " + enemy.getName() + ". Do you choose to take is weapon or armor for yourself?");
                System.out.println("Choose a slot to for the weapon or throw it away ");
                for(int i = 0; i < kevin.getaItem().length; i++)
                {
                    System.out.print((i+1)+". " + kevin.getaItem()[i].getName() + " ");
                    if(i == kevin.getaItem().length-1) {
                        System.out.println((i + 2) + ". vault " + enemy.getaItem()[0].getName());
                        System.out.println((i + 3) + ". throw away " + enemy.getaItem()[0].getName());
                    }
                }
                System.out.println();
                oop=keyboard.nextInt();
                if(oop==4)
                    kevin.ToVault(enemy.getaItem()[0]);
                else if(oop<4) {
                    kevin.ItoA(enemy.getaItem()[0], oop);
                }
                if(enemy.getaItem()[2]!=null)
                {
                    System.out.println("Choose a slot to for the weapon or throw it away ");
                }else {
                    System.out.println("Choose a slot to for the armor or throw it away ");
                }
                for(int i = 0; i < kevin.getaItem().length; i++)
                {
                    System.out.print((i+1)+". " + kevin.getaItem()[i].getName() + " ");
                    if(i == kevin.getaItem().length-1) {
                        System.out.println((i + 2) + ". vault " + enemy.getaItem()[1].getName());
                        System.out.println((i + 3) + ". throw away " + enemy.getaItem()[1].getName());
                    }
                }
                System.out.println();
                oop=keyboard.nextInt();
                if(oop==4)
                    kevin.ToVault(enemy.getaItem()[1]);
                else if(oop<4) {
                    kevin.ItoA(enemy.getaItem()[1], oop);
                }
                if(enemy.getaItem()[2]!=null)
                {
                    System.out.println("Choose a slot to for the armor or throw it away ");
                    for(int i = 0; i < kevin.getaItem().length; i++)
                    {
                        System.out.print((i+1)+". " + kevin.getaItem()[i].getName() + " ");
                        if(i == kevin.getaItem().length-1) {
                            System.out.println((i + 2) + ". vault " + enemy.getaItem()[2].getName());
                            System.out.println((i + 3) + ". throw away " + enemy.getaItem()[2].getName());
                        }
                    }
                    System.out.println();
                    oop=keyboard.nextInt();
                    if(oop==4)
                        kevin.ToVault(enemy.getaItem()[2]);
                    else if(oop<4) {
                        kevin.ItoA(enemy.getaItem()[2], oop);
                    }
                }
                kevin.addMoves();
                System.out.println();
            }else{
                kevin.ToMVault(new Material(enemy.getMat()));
                System.out.println("You received "+enemy.getMat()+" from "+enemy.getName());
                System.out.println();
            }
            kevin.addExp();
            if(enemy.getLevel()-kevin.getLevel()>4)
                kevin.addExp();
            if(enemy.getLevel()-kevin.getLevel()>9)
                kevin.addExp();
            if(enemy.getLevel()-kevin.getLevel()>14)
                kevin.addExp();
            if(enemy.getLevel()-kevin.getLevel()>19)
                kevin.addExp();*/

        }
    }
    //turn based battle system with first attack determined by speed
    //has not incorporated skills, magic or potions but has the general combat flow
    public int attack(String a,Player kevin, Player enemy) throws IOException {
        dam=0;
        BufferedReader scan=new BufferedReader(new FileReader("src/Attacks"));
        Scanner lnScan=null;
        int index=0;
        boolean isAtk=false;
        String line = null;
        int damage = 0;
        while((line=scan.readLine())!=null&& !isAtk) {
            lnScan=new Scanner(line);
            lnScan.useDelimiter(",");
            while(lnScan.hasNext()) {
                String u = lnScan.next();
                if(a.equals(u))
                    isAtk=true;
                if(index==1)
                    damage=Integer.parseInt(u);
                //add more here like elements
                index++;
            }
            index=0;

        }
        scan.close();
        //damage modification to be done here ie elemental advantage, attack power, defense
        return damage;
    }
    //attacks read form attack csv file
    public void printStats(Player k)
    {

    }
    public static void printMoves(ArrayList<String> m)
    {
        for(int i = 0; i< m.size(); i++)
        {
            System.out.print((i+1)+". "+m.get(i)+" ");
        }
        System.out.println();
    }
}
