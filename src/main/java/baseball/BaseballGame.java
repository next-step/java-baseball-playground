package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballGame {
    public void start() {
        String number;

        do{
            number = createNumber();
        } while (play(number));
    }

    public boolean play(String number) {
        int strike = 0;

        while (strike < 3) {
            String inputNumber = getInputNumber();

            int ball = checkBall(number, inputNumber);
            strike = checkStrike(number, inputNumber);

            System.out.println(createCompareResult(ball, strike));
        }

        return isEnd();
    }

    // 1. 서로 다른 수로 이루어진 3자리의 수를 생성한다.
    public String createNumber() {
        final Random random = new Random();
        final Set<String> set = new HashSet<>();
        while (set.size() < 3) {
            set.add(String.valueOf(random.nextInt(9) + 1));
        }

        return set.stream().map(String::valueOf).collect(Collectors.joining());
    }

    // 2. 숫자를 입력 받는다.
    public String getInputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");

        // 2-1. 문자열을 입력 받는다.
        final Scanner kb = new Scanner(System.in);
        final String inputString = kb.nextLine();

        // 2-2. 3자리의 숫자인지 검증한다.
        if (isInputNumberValid(inputString)) {
            System.out.println("3자리의 숫자를 입력해주세요");
        }

        return inputString.trim();
    }

    private boolean isInputNumberValid(final String inputString) {
        return isNumber(inputString) && inputString.length() == 3;
    }

    private boolean isNumber(final String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    // 3. 정답과 입력한 수를 비교한다.
    // 3-1. 볼인지 확인한다.
    public int checkBall(final String number,
                         final String inputNumber) {
        int ball = 0;

        final char first = number.charAt(0);
        final char second = number.charAt(1);
        final char third = number.charAt(2);

        if (inputNumber.charAt(0) == second || inputNumber.charAt(0) == third) {
            ball++;
        }
        if (inputNumber.charAt(1) == first || inputNumber.charAt(1) == third) {
            ball++;
        }
        if (inputNumber.charAt(2) == first || inputNumber.charAt(2) == second) {
            ball++;
        }

        return ball;
    }

    // 3-2. 스트라이크인지 확인한다.
    public int checkStrike(final String number,
                           final String inputNumber) {
        int strike = 0;

        if (number.charAt(0) == inputNumber.charAt(0)) {
            strike++;
        }
        if (number.charAt(1) == inputNumber.charAt(1)) {
            strike++;
        }
        if (number.charAt(2) == inputNumber.charAt(2)) {
            strike++;
        }

        return strike;
    }

    // 4. 비교한 결과를 생성한다.
    public String createCompareResult(final int ball,
                                   final int strike) {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        final StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }

        return sb.toString().trim();
    }

    // 5. 게임을 종료할지 선택한다.
    public boolean isEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final Scanner kb = new Scanner(System.in);
        final int inputContinueNumber = kb.nextInt();

        if (inputContinueNumber == 1) {
            return true;
        } else if (inputContinueNumber == 2) {
            System.exit(0);
        }

        return false;
    }
}
