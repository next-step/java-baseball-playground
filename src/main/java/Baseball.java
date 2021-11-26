import java.util.List;

public class Baseball {
    private final List<Integer> playerBall;
    private final List<Integer> comBall;
    private int strike;
    private int ball;

    protected Baseball(List<Integer> playerBall, List<Integer> comBall) {
        this.playerBall = playerBall;
        this.comBall = comBall;
        this.strike = 0;
        this.ball = 0;
    }

    public void play() {
        if (isThereNum()) {
            this.ball = this.ballCount();
            this.strike = this.strikeCount();
        }
    }

    public void showResult() {
        if(this.strike != 0 || this.ball != 0){
            System.out.println(this.ball + "BALL " + this.strike + "STRIKE");
        }
        System.out.println("NOTHING");
    }

    protected boolean isThereNum() {
        boolean isThereNum = false;
        for (Integer integer : playerBall) {
            if (comBall.contains(integer)) {
                isThereNum = true;
                break;
            }
        }
        return isThereNum;
    }

    protected int strikeCount() {
        int strike = 0;
        for (int i = 0; i < playerBall.size(); i++) {
            if (comBall.get(i).equals(playerBall.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    protected int ballCount() {
        int ball = 0;
        if (isThereNum() && strikeCount() == 0) {
            ball++;
        }
        return ball;
    }
}
