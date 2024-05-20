import gameContinue.GameContinueService;
import input.GAME_PROGRESS_STATUS;

import static input.GAME_PROGRESS_STATUS.isProgress;

public class NumberBaseballGamePlayService {

    public void play() {
        NumberBaseballGameService numberBaseballGameService = new NumberBaseballGameService();
        GameContinueService gameContinueService = new GameContinueService();

        GAME_PROGRESS_STATUS gameProgressStatus = GAME_PROGRESS_STATUS.PROGRESS;

        while (isProgress(gameProgressStatus)) {
            numberBaseballGameService.playOneGame();

            gameProgressStatus = gameContinueService.chooseGameContinueOrTerminate();

        }
    }
}
