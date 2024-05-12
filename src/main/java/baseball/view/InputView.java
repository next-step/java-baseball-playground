package baseball.view;

import java.util.Scanner;

// 사용자의 숫자를 받는 기능
public class InputView {
    public String getUserInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        return new Scanner(System.in).nextLine();
    }
}
