package study.numberBaseballGame;

import java.util.Scanner;

import static study.numberBaseballGame.OutputView.*;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String insertExpectedThreeNumbers() {
        String inputThreeNumbers = sc.nextLine();

        try {
            assertInputString(inputThreeNumbers);
        } catch (IllegalArgumentException e) {
            InvalidInputWarningMessage();
            inputThreeNumbers = sc.nextLine();
        }
        return inputThreeNumbers;
    }

    public static int insertContinueGame() {
        int continueGameToken = sc.nextInt();
        try {
            assertInputNumber(continueGameToken);
        } catch (IllegalArgumentException e) {
            InvalidInputWarningMessage();
            continueGameToken = sc.nextInt();
        }
        return continueGameToken;
    }

    private static void assertInputNumber(int number) {
        if (number == 1 || number == 2) return;
        throw new IllegalArgumentException("허용하지 않는 숫자 입력입니다.");
    }

    private static void assertInputString(String s) {
        if (s == null || s.length() != 3) throw new IllegalArgumentException("입력된 문자열의 길이가 3이 아닙니다.");
        if (!s.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
        if (s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(0) == s.charAt(2))
            throw new IllegalArgumentException("숫자 세 개는 서로 다른 숫자여야합니다..");
    }
}
