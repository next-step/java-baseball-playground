package baseball;

public class GameController {
    private Defender gameDefender;
    private InputView gameInputView;
    private ResultView gameResultView;

    public GameController(Defender defender, InputView inputView, ResultView resultView) {
        gameDefender = defender;
        gameInputView = inputView;
        gameResultView = resultView;
    }

    public void prepareDefenderGameDigits() {
        gameDefender.prepareGameDigits();
    }

    public void evaluatePlayerData(String data) {
        if (data.equals(Constant.EMPTY_DATA)) {
            return;
        }

        gameDefender.evaluate(data);
    }

    public int getBallCount() {
        return gameDefender.getBallCount();
    }

    public int getStrikeCount() {
        return gameDefender.getStrikeCount();
    }

    public Boolean isTripleStrike() {
        return gameDefender.isTripleStrike();
    }

    public void printInputTripleGameDigitsMessage() {
        gameInputView.printInputTripleGameDigitsMessage();
    }

    public String readTripleGameDigits() {
        return gameInputView.readTripleGameDigits();
    }

    public void printMenuMessage() {
        gameInputView.printMenuMessage();
    }

    public String readMenuInput() {
        return gameInputView.readMenuInput();
    }

    public void printGameResult() {
        gameResultView.printGameResult(getBallCount(), getStrikeCount());
    }

    public void printStageDoneMessage() {
        gameResultView.printStageDoneMessage();
    }

    public void printGameCloseMessage() {
        gameResultView.printGameCloseMessage();
    }

    public String getEmptyInputData() {
        return Constant.EMPTY_DATA;
    }

}
