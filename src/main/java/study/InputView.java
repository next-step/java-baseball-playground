package study;

import java.util.Scanner;

public class InputView {

    public static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    public static final String REPEAT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String IS_REPEAT = "1";

    public String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public boolean isRepeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(REPEAT_MESSAGE);
        String input = scanner.nextLine();
        return input.equals(IS_REPEAT);
    }

}
