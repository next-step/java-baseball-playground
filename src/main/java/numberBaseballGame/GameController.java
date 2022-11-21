package numberBaseballGame;

public class GameController {
    Referee judgeGame;

    public GameController(Referee referee) {
        judgeGame = referee;
    }

    public boolean continueGame() {

        if (judgeGame.strikeCount() == 3) {
            return false;
        }

        return true;
    }
}
