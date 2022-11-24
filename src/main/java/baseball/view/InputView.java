package baseball.view;

import baseball.utils.Validator;
import java.util.Scanner;

public class InputView {
    private Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public int readNumber() {
        String number = sc.next();
        validateNumber(number);
        return Integer.parseInt(number);
    }

    private static void validateNumber(String number) {
        Validator.checkIsNumber(number);
        Validator.checkBoundary(number);
        Validator.checkSize(number);
    }
}
