import java.util.List;

public class BallAndStrike {

    public static void show(final List<String> randomNumber, final List<String> number) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (randomNumber.get(i).equals(number.get(j))) {
                    if (i == j) {
                        strike++;
                        break;
                    }
                    ball++;
                }
            }
        }

        if (ball + strike == 0) {
            System.out.println("Four Ball or Nothing");
            return;
        }

        System.out.println(ball + " 볼 " + strike + "스트라이크");
    }
}
