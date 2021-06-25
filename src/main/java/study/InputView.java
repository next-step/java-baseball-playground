package study;

import java.util.Scanner;

public class InputView {

    public String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }

    public boolean isRepeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        return input.equals("1");
    }

}
