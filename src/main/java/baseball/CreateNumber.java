package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateNumber {

    public int createRandomNumber(List<Integer> numberList) {
        Random random = new Random();
        if(numberList.contains((random.nextInt(9)+1))){
            createRandomNumber(numberList);
        }
        return random.nextInt(9)+1;
    }

    public List<Integer> makeRandomNumbers() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numberList.add(createRandomNumber(numberList));
        }
        System.out.println(numberList);
        return numberList;
    }
}
