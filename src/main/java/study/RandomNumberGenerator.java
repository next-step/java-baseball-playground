package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    private SystemOperator systemOperator;
    public static List<Ball> generate() {
        List<Integer> list = new ArrayList();
        List<Ball> ballList = new ArrayList();
        Random random = new Random();
        for (int i=0;i<3;i++) {
            while (true) {
                int number = random.nextInt(9) + 1;
                if (Validator.isUnique(number, list)) {
                    Ball ball = new Ball(i, number);
                    list.add(number);
                    ballList.add(ball);
                    break;
                }
            }
        }
        return ballList;
    }
}
