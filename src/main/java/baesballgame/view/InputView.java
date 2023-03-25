package baesballgame.view;

import java.util.Scanner;

public class InputView {

    public int input() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public int restartOrEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}