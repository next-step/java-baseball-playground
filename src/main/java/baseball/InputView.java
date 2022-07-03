package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    ScannerUtil scannerUtil;
    final String TRIPLE_DIGIT_REGEX_PATTERN = "^\\d{3}$";
    final String MENU_RETRY = "1";
    final String MENU_CLOSE = "2";
    final String MENU_REGEX_PATTERN = String.format("^[%s%s]$", MENU_RETRY, MENU_CLOSE);

    static class JavaScanner implements ScannerUtil {

        @Override
        public String nextLine() {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
    }

    public InputView(ScannerUtil util) {
        scannerUtil = util;
    }

    public InputView() {
        scannerUtil = new JavaScanner();
    }

    public Boolean verifyUniqueTripleGameDigits(String input) {
        if (input.charAt(0) == input.charAt(1)) {
            return false;
        }

        if (input.charAt(0) == input.charAt(2)) {
            return false;
        }

        return input.charAt(1) != input.charAt(2);
    }

    public Boolean verifyTripleGameDigits(String input) {
        return Pattern.matches(TRIPLE_DIGIT_REGEX_PATTERN, input);
    }

    public void printInputTripleGameDigitsMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public String readTripleGameDigits() {
        String userInput = scannerUtil.nextLine();

        if (verifyTripleGameDigits(userInput) == false) {
            throw new IllegalArgumentException(String.format("숫자3자리 규칙에 맞지 않음: %s", userInput));
        }

        if (verifyUniqueTripleGameDigits(userInput) == false) {
            throw new IllegalArgumentException(String.format("숫자 중에 중복값이 있음: %s", userInput));
        }

        return userInput;
    }

    public void printMenuMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public String readMenuInput() {
        String userInput = scannerUtil.nextLine();

        if (verifyMenuInput(userInput) == false) {
            throw new IllegalArgumentException(String.format("없는 메뉴를 선택함: %s", userInput));
        }

        return userInput;
    }

    public Boolean verifyMenuInput(String input) {
        return Pattern.matches(MENU_REGEX_PATTERN, input);
    }
}
