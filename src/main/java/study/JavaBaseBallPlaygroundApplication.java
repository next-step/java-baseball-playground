package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaBaseBallPlaygroundApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            List<Ball> list = new ArrayList<>();
            List<Ball> randomNumber = RandomNumberGenerator.generate();

            System.out.println("숫자를 입력해주세요");
            for (int i=0;i<3;i++) {
                Ball ball  = new Ball(i, (Integer) scanner.nextInt());
                list.add(ball);
            }

            Balls balls = new Balls(list);
            Balls computer = new Balls(randomNumber);

            ResultDTO result = BaseBallGame.play(computer, balls);
            if (SystemOperator.isCorrect(result)) {
                int operator = scanner.nextInt();
                if (operator == 2) {
                    break;
                } else if (operator == 1) {
                    continue;
                }
            }
        }
    }
}
