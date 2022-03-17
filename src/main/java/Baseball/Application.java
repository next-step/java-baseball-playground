package Baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int index = 1;
        while(index != 2)
        {
            //컴퓨터 볼 지정
            BallNumberMaker ballNumberMaker = new BallNumberMaker();
            ballNumberMaker.makeBallNumbers();
            Balls computerBalls = new Balls(ballNumberMaker.getBallNumbers());
            Scanner scanner = new Scanner(System.in);
            //컴퓨터볼과 사용자볼 비교 후 결과출력
            PlayResult playResult = new PlayResult();
            while(playResult.isGameEnd() == false) {
                //사용자 볼 지정
                System.out.print("1~9까지 숫자를 중복없이 연속해서 3개를 입력해주세요 : ");
                ballNumberMaker.makeBallNumbers(scanner.nextLine());
                Balls userBalls = new Balls(ballNumberMaker.getBallNumbers());
                playResult = computerBalls.play(userBalls);
                System.out.printf("%d볼 %d스트라이크\n",
                        playResult.getBallCount(), playResult.getStrikeCount());
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            index = scanner.nextInt();
        }
    }
}
