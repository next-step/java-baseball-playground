package training2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private List<Integer> playerNum;

    public List<Integer> getPlayerNum() {
        return playerNum;
    }

    public void inputScanner(boolean pass) {
        if (!pass) {
            System.out.print("숫자를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            playerNum = new ArrayList<>();
            String input = scanner.next();

            for (String number : input.split("")) {
                playerNum.add(Integer.parseInt(number));
            }

            return;
        }

        if (pass) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            Scanner scanner = new Scanner(System.in);
            int result = scanner.nextInt();

            if (result == 1) {
                pass = false;
                inputScanner(pass);
            }

            if (result == 2) {
                System.exit(0);
            }
        }
    }
}
