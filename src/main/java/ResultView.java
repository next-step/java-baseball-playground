import java.util.List;
import java.util.Scanner;

public class ResultView {

    private static Scanner scanner = new Scanner(System.in);

    public static boolean endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        return scanner.nextInt() == 2;
    }

    public static void showBallAndStrike(int ball, int strike){

        if(ball + strike == 0){
            System.out.println("Four ball or Nothing");
            return;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");

    }
}
