import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Accessory extends Item {
    BufferedReader scan = new BufferedReader(new FileReader("src/Weapon"));
    Scanner lnScan = null;
    int index = 0;
    boolean isItem;
    public Accessory(String n) throws IOException {
        String line = null;
        while ((line = scan.readLine()) != null && isItem == false) {
            lnScan = new Scanner(line);
            lnScan.useDelimiter(",");
            while (lnScan.hasNext()) {
                String u = lnScan.next();
                if (index == 0)
                    name = n;
                if (name.equals(u))
                    isItem = true;
                if (index == 1)
                    pAtk = Integer.parseInt(u);
                if (index == 2)
                    mAtk = Integer.parseInt(u);
                if (index == 3)
                    pDef = Integer.parseInt(u);
                if (index == 4)
                    mDef = Integer.parseInt(u);
                if (index == 5)
                    speedB = Integer.parseInt(u);
                if (index == 6)
                    strengthB = Integer.parseInt(u);
                if (index == 7)
                    magicB = Integer.parseInt(u);
                if (index == 8)
                    speedR = Integer.parseInt(u);
                if (index == 9)
                    strengthR = Integer.parseInt(u);
                if (index == 10)
                    magicR = Integer.parseInt(u);
                if(index==11)
                    type=u;
                if(index==12)
                    description=u;
                if(index>12)
                    moves.add(u);
                index++;
            }
            index = 0;

        }
        scan.close();
    }
}

