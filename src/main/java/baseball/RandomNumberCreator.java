package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberCreator {
    private static final int MAX_RANGE = 9;

    public static int makeRandomNumber(int range) {
        return new Random().nextInt(range);
    }

    public static List<Integer> makeNumberList() {
        List<Integer> list = new ArrayList<>();

        while(list.size()!=3){
            list.add(randomNumberLoop(list));
        }

        return list;
    }

    private static int randomNumberLoop(List<Integer> list){
        int randomNumber = makeRandomNumber(MAX_RANGE);
        while(list.contains(randomNumber)){
            randomNumber = makeRandomNumber(MAX_RANGE);
        }
        return randomNumber;
    }


}
