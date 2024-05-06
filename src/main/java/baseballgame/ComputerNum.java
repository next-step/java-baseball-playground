package baseballgame;


import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ComputerNum {
    Random random = new Random();
    public List<Integer> ComputerNumber(){

        List<Integer> com_num = new ArrayList<>(); // Create list contains answer
        while (com_num.size() < 3) {
            int randNum = random.nextInt(10);
            if (!com_num.contains(randNum)) {
                com_num.add(randNum);
            }
        }
        return com_num;
    }
}
