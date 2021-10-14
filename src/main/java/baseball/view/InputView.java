package baseball.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static String getInput() {
        System.out.print("1~9로 이루어지며 중복되지 않는 3자리 숫자를 입력해주세요 : ");
        return  sc.nextLine();
    }

    public static String askRestart() {
        System.out.println("게임을 다시 시작하시려면 1번, 종료하시려면 2번을 눌러주세요.");
        return sc.nextLine();
    }


}
