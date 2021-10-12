package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    Scanner sc = new Scanner(System.in);

    public String getInput() {
        System.out.print("1~9로 이루어지며 중복되지 않는 3자리 숫자를 입력해주세요 : ");
        String input = sc.nextLine();
        try {
            validateBallInput(input);
        } catch (InputMismatchException e) {
            input = handleInputException(e);
        }
        return input;
    }

    //Balls에서 각 볼의 크기와 중복을 검사하기 때문에 여기서는 길이만 검사한다.
    public boolean validateBallInput(String input) throws RuntimeException {
        if (input.length() != 3) {
            throw new InputMismatchException("입력값이 올바르지 않습니다.");
        }
        return input.length() == 3;
    }

    private String handleInputException(InputMismatchException e) {
        System.out.println("입력값이 올바르지 않습니다.");
        User user = new User();
        if (e.getMessage().equals("입력값이 올바르지 않습니다.")) {
            return user.getInput();
        }
        return user.askRestart();

    }

    private boolean validateRestartInput(String input) throws RuntimeException {
        if (input.length() != 1 || Integer.parseInt(input) > 2) {
            throw new InputMismatchException("1 혹은 2 를 입력해주세요");
        }
        return Integer.parseInt(input) == 2;
    }

    public String askRestart() {
        System.out.println("게임을 다시 시작하시려면 1번, 종료하시려면 2번을 눌러주세요.");
        String input = sc.nextLine();
        try {
            validateRestartInput(input);
        } catch (InputMismatchException e) {
            handleInputException(e);
        }
        System.out.println(input);
        return input;
    }

}
