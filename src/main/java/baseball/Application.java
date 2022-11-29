package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        while (true) {
            CompareBall c = new CompareBall();
            c.playerBall.createPBall();
            c.computerBall.createCBall();
            c.strikeCheck();
            c.ballCheck();
            System.out.print(c.getStrike() + "스트라이크\n");
            System.out.println(c.getStrike() + "볼");
            if (c.getStrike() == 3) {
                System.out.println("게임을 종료하시겠습니까? 1: 재시작, 2: 종료");
                End();
            }

        }

    }

    static void End() {
        Scanner sc = new Scanner(System.in);
        int endNumber = sc.nextInt();
        if (endNumber == 2) {
            System.exit(0);
        }
    }
}
