package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberCreator {
    private static final int MAX_RANGE = 9;
    private static final int MIN_RANGE = 1;

    public static int makeRandomNumber(int range) {
        return new Random().nextInt(range)+MIN_RANGE;
    }

    public static List<Integer> makeNumbers() {
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
        System.out.println(randomNumber);
        return randomNumber;
    }


}
