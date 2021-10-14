package baseball.model;

import java.util.InputMismatchException;

public class User {

    public void validateBallInput(String input) throws RuntimeException {
        if (input.length() != 3) {
            throw new InputMismatchException("입력값이 올바르지 않습니다.");
        }
    }

    public void validateRestartInput(String input) throws RuntimeException {
        if (input.length() != 1 || Integer.parseInt(input) > 2) {
            throw new InputMismatchException("1 혹은 2 를 입력해주세요");
        }
    }

}
