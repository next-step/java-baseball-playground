package baseball.view;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.next();
    }
}
