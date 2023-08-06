import study.numberBaseball.NumberBaserball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int gameStart = 1;
        int number = 0;
        int input = 0;
        NumberBaserball baseball = new NumberBaserball();
        number = baseball.initNumber();
        while (gameStart == 1){

            input = baseball.scanNumber(sc);

            int ballCount = baseball.countBall(number, input);
            int strikeCount = baseball.countStrike(number, input);

            String result = baseball.printResult(ballCount, strikeCount);
            System.out.println(result);

            if(strikeCount != 3){
                continue;
            }

            if(baseball.contiueGame(sc) == 1){
                baseball.initNumber();
                continue;
            }

            gameStart = 2;
            baseball.printGameOver();
        }

    }
}
