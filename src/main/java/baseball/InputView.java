package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    ScannerUtil scannerUtil;
    final String TRIPLE_DIGIT_REGEX_PATTERN = "^\\d{3}$";

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
}
