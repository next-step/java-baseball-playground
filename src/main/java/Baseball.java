import java.util.Arrays;

public class Baseball {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RandomNumber.selectNumbers();
        System.out.println(Arrays.toString(RandomNumber.computerNumbers));

        while (!GameWin.win) {
            String input = inputView.getInput();
            ScoreCount scoreCount = new ScoreCount(input);
            scoreCount.win();
        }

    }

}
