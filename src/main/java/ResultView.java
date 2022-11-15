import java.util.List;

public class ResultView {

    private Ball ball;
    private Strike strike;

    public ResultView() {
        this.ball = new Ball();
        this.strike = new Strike();
    }

    public void showBallAndStrike(List<String> randomNumber, List<String> number) {

        final int ballCount = ball.getBall(randomNumber, number);
        final int strikeCount = strike.getStrike(randomNumber, number);

        if (ballCount + strikeCount == 0) {
            fourBall();
            return;
        }

        showBallAndStrike(ballCount,strikeCount);

    }

    private void showBallAndStrike(int ball,int strike){
        System.out.println(ball + "볼 " + strike + "스트라이크");

    }

    private void fourBall(){
        System.out.println("Four ball or Nothing");
    }
    public void choose(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    public void inputNumbers(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public void correct(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void threeNumbers(){
        System.out.println("3 자리수를 입력해주세요");
    }
}
