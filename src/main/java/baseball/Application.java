package baseball;

public class Application {
    public static void main(String[] args) {
        Defender player = new Defender();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        GameController controller = new GameController(player, inputView, resultView);
        GameBoard board = new GameBoard(controller);

        board.run();
    }

}
