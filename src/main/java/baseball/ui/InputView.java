package baseball.ui;

import java.util.Scanner;

public class InputView {
    static final Scanner sc = new Scanner(System.in);

    public String receiveInput() {
        System.out.println("숫자를 입력해 주세요 : ");
        String input = sc.nextLine();
        if(input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        return input;
    }

    public int restartOrQuitInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(sc.nextLine());
    }
}
