package baseball.model;

import java.util.InputMismatchException;

public class User {

    public void validateRestartInput(String input) throws RuntimeException {
        if (input.length() != 1 || Integer.parseInt(input) > 2) {
            throw new InputMismatchException("1 혹은 2 를 입력해주세요");
        }
    }

}
