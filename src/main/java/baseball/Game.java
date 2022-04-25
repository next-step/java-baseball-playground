package baseball;

import java.util.List;

public class Game {

    public static void main(String[] args) {

        NumberGenerator numberGenerator = new NumberGenerator();
        Balls com = numberGenerator.randomNumberGenerator();
        List<Integer> user = InputView.userInput();

        PlayResult result = com.play(user);
        ResultView.result(result);
    }
}
