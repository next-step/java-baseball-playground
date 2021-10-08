package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    public static List<Integer> makeFullRandomNumber(){
        List<Integer> answer = new ArrayList<>();

        while(answer.size()!=3){
            answer.add(makeRandomNumber(answer));
        }
        return answer;
    }

    public static int makeRandomNumber(List<Integer> balls) {
        Random random = new Random();
        int result = random.nextInt(9) + 1;

        while (!checkRange(result) || balls.contains(result)) {
            result = random.nextInt(9) + 1;
        }

        return result;
    }

    public static boolean checkLength(int balls) {
        return String.valueOf(balls).length() == 3;
    }

    public static boolean checkRange(int ball) {
        if (ball > 0 && ball < 10) {
            return true;
        }
        return false;
    }

}
