package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BaseballView {

    private BaseballView(){}
    //String.format not in System.out.println : build error
    //여기에서 showGameResult 재호출 시 무한loop

    public static List<Integer> askGameInput() {
        System.out.println("숫자를 입력해 주세요 :");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> gameInput = checkInput(input);
        return gameInput;
    }

    private static List<Integer> checkInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값 없습니다");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자릿수 아닙니다");
        }
        return Arrays.stream(input.split(""))
                .filter(o -> Pattern.matches("^[1-9]*$", o))
                .map(o -> Integer.parseInt(o))
                .collect(Collectors.toList());
    }

    public static void showGameResult(BaseballGame baseballGame, List<Integer> me) {
        if (baseballGame.isStrike(me) == 0 && baseballGame.isBall(me) == 0) {
            System.out.println("포볼");
        }
        if (baseballGame.isStrike(me) == 0) {
            System.out.println(baseballGame.isBall(me) + "볼");
        }
        if (baseballGame.isStrike(me) == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (baseballGame.isBall(me) == 0 && baseballGame.isStrike(me) != 3) {
            System.out.println(baseballGame.isStrike(me) + "스트라이크");
        }
        if (baseballGame.isBall(me) != 0 && baseballGame.isStrike(me) != 0) {
            System.out.println(baseballGame.isBall(me) + "볼 " + baseballGame.isStrike(me) + "스트라이크");
        }
    }
}
