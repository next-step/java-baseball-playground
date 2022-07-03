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

    public Boolean verifyUniqueTripleGameDigits(String userInput) {
        if (userInput.charAt(0) == userInput.charAt(1)) {
            return false;
        }

        if (userInput.charAt(0) == userInput.charAt(2)) {
            return false;
        }

        return userInput.charAt(1) != userInput.charAt(2);
    }

    public Boolean verifyTripleGameDigits(String userInput) {
        return Pattern.matches(TRIPLE_DIGIT_REGEX_PATTERN, userInput);
    }

    public void printInputTripleGameDigitsMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }
}
