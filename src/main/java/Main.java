import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static LottoNumber lottoNumber = new LottoNumber();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            String answer = lottoNumber.makeLottoNumbers();

            while (true) {
                final String number = input();

                if (correctAnswer(answer, number)) {
                    break;
                }

                getBallAndStrike(answer, number);
            }

            if (continueGame()) {
                break;
            }
        }
    }

    private static boolean continueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        int num = scanner.nextInt();

        return num == 1;
    }

    private static boolean correctAnswer(final String answer, final String number) {
        if (answer.equals(number)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("정답은 : " + answer);
            return true;
        }

        return false;
    }

    private static void getBallAndStrike(final String answer, final String number) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer.charAt(i) == number.charAt(j)) {
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

    private static String getAnswer() {

        String answer = "";

        while (true) {
            final Set<Integer> three = getRandomNumber();

            if (three.size() == 3) {
                answer = makeAnswer(three);
                break;
            }
        }
        return answer;
    }

    private static Set<Integer> getRandomNumber() {
        Random rand = new Random();
        final Set<Integer> three = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            final int randomNumber = rand.nextInt(9) + 1;
            three.add(randomNumber);
        }

        return three;

    }

    private static String makeAnswer(final Set<Integer> three) {
        String answer = "";

        for (Integer num : three) {
            answer += num;
        }

        return answer;
    }

    private static String input() {
        System.out.print("숫자를 입력해 주세요 : ");

        return scanner.nextLine();
    }
}
