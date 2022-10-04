package baseballgame.domain.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_USER_BALL_MESSAGE = "숫자를 입력해 주세요 :";
    private static final String RETRY_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> getUserBalls() throws RuntimeException {
        System.out.println(INPUT_USER_BALL_MESSAGE);

        return validateCountAndTransferToInt(scanner.next());
    }

    private static List<Integer> validateCountAndTransferToInt(String input) {
        InputValidator.checkInput(input);

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split("")) {
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }

    public static int retryGame(){
        System.out.println(RETRY_GAME_MESSAGE);
        return InputValidator.checkInt(scanner.nextInt());
    }

}
