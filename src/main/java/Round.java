import java.util.ArrayList;

public class Round {

    private long ball = 0;
    private long strike = 0;
    private boolean isOut = false;

    public Round() { //테스트용

    }
    public Round(int ball, int str, boolean isOut) { //테스트용
        this.ball = ball;
        this.strike = str;
        this.isOut = isOut;
    }

    public Round(ArrayList<Integer> correctAnswer, ArrayList<Integer> inputs) {
        ball = checkBall(correctAnswer, inputs);
        strike = checkStrike(correctAnswer, inputs);
        isOut = checkOut(correctAnswer, inputs);
    }

    long checkStrike(ArrayList<Integer> correctAnswer, ArrayList<Integer> inputs) {
        long strikeCount = correctAnswer.stream()
                .filter(answer -> answer == inputs.get(correctAnswer.indexOf(answer)))
                .count();
        return strikeCount;
    }

    long checkBall(ArrayList<Integer> correctAnswer, ArrayList<Integer> inputs) {
        long ballCount = correctAnswer.stream()
                .filter(answer -> inputs.stream().anyMatch(input->input==answer))
                .filter(answer -> answer != inputs.get(correctAnswer.indexOf(answer)))
                .count();
        return ballCount;
    }

    boolean checkOut(ArrayList<Integer> correctAnswer, ArrayList<Integer> inputs) {
        long count = correctAnswer.stream()
                .filter(answer -> inputs.stream().noneMatch(input -> answer == input))
                .count();
        if(count==3)
            return true;
        return false;
    }

    boolean isHomeRun(long strike) {
        if(strike==3)
            return true;
        return false;
    }

    public long getBall() {
        return ball;
    }

    public long getStrike() {
        return strike;
    }

    public boolean isOut() {
        return isOut;
    }
}
