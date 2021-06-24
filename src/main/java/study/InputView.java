package study;

import java.util.Scanner;

public class InputView {
    public String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    public boolean repeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if ("1".equals(scanner.nextLine()))
            return true;
        return false;
    }

}
