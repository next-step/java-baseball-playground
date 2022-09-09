package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        startGame(br);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (br.readLine().equals("1")){
            startGame(br);
        }
    }

    public static void startGame(BufferedReader br) throws IOException {
        BaseBallGame baseBallGame = new BaseBallGame();
        String answerNumber = baseBallGame.createNumber(3);
        boolean gameStatus = true;

        while (gameStatus) {
            System.out.print("숫자를 입력해 주세요 : ");
            String inputNumbers = br.readLine();
            String result = baseBallGame.gameResults(answerNumber, inputNumbers);
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("개의 숫자르 ㄹ모두 맞히셨습니다! 게임 종료");
                gameStatus = false;
            }
        }
    }
}
