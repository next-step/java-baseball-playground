package baseball.view;

import java.util.Scanner;

public class InputView {

    public static final String ASK_FOR_NUMBER = "\n숫자를 입력해 주세요 :";
    public static final String IF_NEW_GAME_TRUE = "게임을 새로 시작하려면 ";
    public static final String IF_NEW_GAME_FALSE = ", 종료하려면 ";
    public static final String ASK_END = "를 입력하세요.";
    public static final String NEW_GAME_TRUE = "1";
    public static final String NEW_GAME_FALSE = "2";

    private InputView() {}

    public static String askInput() {
        System.out.print(ASK_FOR_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    //scanner.nextLine() 입력값에 대해서 변수 저장 필요
    //바로 메서드 조건에 넣었더니 엄청 오래 걸림.
    public static boolean askNewGame() {
        System.out.print(String.format(IF_NEW_GAME_TRUE+"%s"+IF_NEW_GAME_FALSE+"%s"+ASK_END, NEW_GAME_TRUE, NEW_GAME_FALSE));
        Scanner scanner = new Scanner(System.in);
        String numInput = scanner.nextLine();
        if (numInput.equals(NEW_GAME_FALSE)) {
            return false;
        }
        else if (numInput.equals(NEW_GAME_TRUE)) {
            return true;
        }
        return false;
    }
}
