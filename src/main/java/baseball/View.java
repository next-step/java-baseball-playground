package baseball;

import java.util.Scanner;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    public String getInputNumber() {
        return scanner.nextLine();
    }

    public int getOrderNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printNumberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printStrikeOutMessage(int total) {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", total);
    }

    public void printCheckToRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }
}
