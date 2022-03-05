package NumberBaseballGame;

import java.util.Scanner;

public class InputView {
    public void printMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }
    public int inputNumbers() {
        return new Scanner(System.in).nextInt();
    }
}
