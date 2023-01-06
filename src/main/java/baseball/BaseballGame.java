package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballGame {
    public void start() {
        final Scanner kb = new Scanner(System.in);
        String number;

        do {
            number = createNumber();
        } while (play(number, kb));
    }

    public boolean play(final String number,
                        final Scanner kb) {
        int strike = 0;

        while (strike < 3) {
            String inputNumber = getInputNumber(kb);

            int ball = checkBall(number, inputNumber);
            strike = checkStrike(number, inputNumber);

            System.out.println(createCompareResult(ball, strike));
        }

        return isEnd(kb);
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
    public String getInputNumber(final Scanner kb) {

        String inputString;

        do {
            System.out.print("숫자를 입력해 주세요 : ");

            // 2-1. 문자열을 입력 받는다.
            inputString = kb.nextLine();
        } while (!isInputNumberValid(inputString));  // 2-2. 3자리의 숫자인지 검증한다.

        return inputString.trim();
    }

    private boolean isInputNumberValid(final String inputString) {
        if (isNumber(inputString) && inputString.length() == 3) {
            return true;
        }

        System.out.println("3자리의 숫자를 입력해주세요");
        return false;
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

        for (int i = 0; i < 3; i++) {
            strike += isContainNumber(number.charAt(i), inputNumber.charAt(i));
        }

        return strike;
    }

    private int isContainNumber(final char number,
                                final char inputNumber) {
        if (number == inputNumber) {
            return 1;
        }

        return 0;
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
    public boolean isEnd(final Scanner kb) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        int inputContinueNumber;

        do{
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            inputContinueNumber = kb.nextInt();
            kb.nextLine();
        } while (inputContinueNumber != 1 && inputContinueNumber != 2);

        return inputContinueNumber == 1;
    }
}
