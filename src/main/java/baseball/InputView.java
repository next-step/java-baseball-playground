package baseball;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String printAskNumberMsg() {
        System.out.println("1~9사이 중복되지 않는 3가지 숫자를 입력해주세요");
        return (scanner.nextLine());
    }

    public String printAskRestartMsg() {
        System.out.println("게임을 한번더 진행 하시겠습니까? yes or no");
        return (scanner.nextLine());
    }
}