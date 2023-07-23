package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateNumber {

    public int createRandomNumber(List<Integer> numberList) {
        Random random = new Random();
        int randomNumber = random.nextInt(9)+1;
        if(numberList.contains(randomNumber)){
            return createRandomNumber(numberList);
        }
        return randomNumber;
    }

    public List<Integer> makeRandomNumbers() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int a = createRandomNumber(numberList);
            numberList.add(a);
        }
        return numberList;
    }
}
