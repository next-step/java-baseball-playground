import java.util.Scanner;

public class NumberBaseballGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 100;
        int max = 999;
        int com = (int) (Math.random() * (max - min + 1)) + min;

            while (com != -1) {
                System.out.println(com);
                int strike = 0;
                int ball = 0;
                System.out.print("숫자를 입력해 주세요 : ");
                int userNum = sc.nextInt();
                com = NumberBaseballGame.numberCheck(com, userNum, sc);
            }

    }

    public static int numberCheck(int com, int userNum, Scanner sc) {
        int strike = 0, ball = 0;
        int min = 100;
        int max = 999;

        if (com / 100 == userNum / 100) strike++;
        if (com / 10 % 10 == userNum / 10 % 10) strike++;
        if (com % 10 == userNum % 10) strike++;
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int select = sc.nextInt();
            if (select == 1) {
                return (int) (Math.random() * (max - min + 1)) + min;

            } else return -1;
        }
        if (strike != 3) {
            if (com / 100 != userNum / 100 && (com / 10 % 10 == userNum / 100 || com % 10 == userNum / 100)) ball++;
            if (com / 10 % 10 != userNum / 10 % 10 && (com / 100 == userNum / 10 % 10 || com % 10 == userNum / 10 % 10))
                ball++;
            if (com % 10 != userNum % 10 && (com / 100 == userNum % 10 || com / 10 % 10 == userNum % 10)) ball++;
            if (strike != 0 && ball != 0) System.out.printf("%d스트라이크 %d볼 %n", strike, ball);
            if (strike == 0 && ball != 0) System.out.printf("%d볼 %n", ball);
            if (strike != 0 && ball == 0) System.out.printf("%d스트라이크 %n", strike);
            if (strike == 0 && ball == 0) System.out.printf("");
        }
        return com;
    }
}
