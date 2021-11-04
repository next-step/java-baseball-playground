package baseball.view;

import java.util.Scanner;

public class InputView {
    private Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public String input() {
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.next();
    }
}
