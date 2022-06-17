package study.baseball;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class NumberBaseballGame {
    private Balls userBalls;
    private Balls randomBalls;
    private boolean progress;
    PlayGameResult playGameResult;

    public NumberBaseballGame() {
       this(new Balls(), new Balls(), false);
    }

    public NumberBaseballGame(Balls randomBalls, Balls userBalls, Boolean gameState) {
        this(randomBalls, userBalls, gameState, new PlayGameResult(0, 0));
    }

    public NumberBaseballGame(Balls userBalls, Balls randomBalls, boolean progress, PlayGameResult playGameResult) {
        this.userBalls = userBalls;
        this.randomBalls = randomBalls;
        this.progress = progress;
        this.playGameResult = playGameResult;
    }

    public void play() {
        Scanner input = new Scanner(System.in);
        ready();
        while(this.progress) {
            start(input);
            System.out.println(playGameResult.toString());
            System.out.println(this.userBalls.toString() + ":" +this.randomBalls.toString());
            if(!isGameOver(this.randomBalls, this.userBalls)) {
                playGameResult.clear();
                continue;
            }
            gameOverPrint();
            restart(input.nextInt());
        }
    }

    private void ready() {
        this.randomBalls = randomBalls.makeRandomBalls();
        this.userBalls = new Balls();
        this.playGameResult = new PlayGameResult(0, 0);
        this.progress = true;
    }

    private void start(Scanner input) {
        System.out.println("숫자를 입력해 주세요:");
        int[] ballNumbers = splitBallNumber(input.nextInt());
        this.userBalls = initUserBalls(ballNumbers);
    }

    private int[] splitBallNumber(int numbers) {
        return Stream.of(String.valueOf(numbers).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public Balls initUserBalls(int[] numbers) {
        List<Ball> balls = new ArrayList<>();
        int position = 0;
        for (int number : numbers) {
            Ball ball = new Ball(number, position++);
            balls.add(ball);
            checkBalls(ball);
        }
        return new Balls(balls);
    }


    private boolean isGameOver(Balls computerBalls, Balls userBalls) {
        return Objects.equals(computerBalls, userBalls);
    }

    private void gameOverPrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 2, 종료하려면 1를 입력하세요");
    }

    private void checkBalls(Ball userBall) {
        for (Ball computerBall : this.randomBalls.balls()) {
            if (computerBall.isBall(userBall)) {
                playGameResult.addBallCount();
            }
            if (computerBall.isStrike(userBall)) {
                playGameResult.addStrikeCount();
            }
        }
    }

    private void restart(int number) {
        if(isRestart(number)) {
            ready();
            return;
        }
        this.progress = false;
    }

    private boolean isRestart(int number) {
        return number == 2;
    }

}
