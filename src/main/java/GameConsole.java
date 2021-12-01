import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameConsole {
    private final ArrayList<Integer> playerBall;
    private final ArrayList<Integer> comBall;
    private int strike;
    private int ball;

    protected GameConsole(int playerBall, int comBall) {
        String[] playerStrBall = Integer.toString(playerBall).split("");
        int[] playerIntBall = Arrays.stream(playerStrBall).mapToInt(Integer::parseInt).toArray();
        this.playerBall = (ArrayList<Integer>) Arrays.stream(playerIntBall).boxed().collect(Collectors.toList());

        String[] comStrBall = Integer.toString(comBall).split("");
        int[] comIntBall = Arrays.stream(comStrBall).mapToInt(Integer::parseInt).toArray();
        this.comBall = (ArrayList<Integer>) Arrays.stream(comIntBall).boxed().collect(Collectors.toList());

        this.strike = 0;
        this.ball = 0;
    }

    public void play() {
        if (isThereNum()) {
            this.ball = this.ballCount();
            this.strike = this.strikeCount();
        }
        this.showResult();
    }

    public void showResult() {
        if(this.strike != 0 || this.ball != 0){
            System.out.println(this.ball + "볼 " + this.strike + "스타라이크");
            return;
        }
        System.out.println("낫띵");
    }

    public boolean isCorrect() {
        return this.strike == 3;
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
