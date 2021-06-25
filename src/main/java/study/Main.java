package study;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Player player = new Player();
        PlayerService playerService = new PlayerService();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        boolean isRepeat = true;

        player.makeComputersRandomBalls();
        while (isRepeat) {
            String input = inputView.input();
            List<Status> playStatus = player.play(input);

            resultView.result(playStatus);

            boolean isThreeStrike = player.isThreeStrike(playStatus);

            if (isThreeStrike) {
                isRepeat = inputView.isRepeat();
                player.makeComputersRandomBalls();
            }
        }

    }
}
