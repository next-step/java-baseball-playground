package baseball.view;

import java.util.Scanner;

public class InputView {
    private InputView() {}

    public static String askInput() {
        System.out.print("\n숫자를 입력해 주세요 :");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    //scanner.nextLine() 입력값에 대해서 변수 저장 필요
    //바로 메서드 조건에 넣었더니 엄청 오래 걸림.
    public static boolean askNewGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String numInput = scanner.nextLine();
        if (numInput.equals("2")) {
            return false;
        }
        else if (numInput.equals("1")) {
            return true;
        }
        return false;
    }
}
