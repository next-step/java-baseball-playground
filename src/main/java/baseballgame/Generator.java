package baseballgame;

import java.util.ArrayList;
import java.util.Random;

public class Generator {

    public ArrayList generateComputerNum() {
        ArrayList list = new ArrayList();
        while (list.size() < 3) {
            int num = new Random().nextInt(8)+1;
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
        }
        return list;
    }
}
