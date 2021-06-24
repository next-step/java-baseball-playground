package study;

public class Main {

    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();
    static GameService gameService = new GameService();

    public static void main(String[] args) {

        Game game = gameService.makeGame();
        gameService.setRandomNumber(game);

        while (true) {
            String input = inputView.input();

            Status[] statuses = gameService.compareWithUserInput(game, input);
            resultView.result(statuses);
            if (gameService.isDoneGame(statuses)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                if (inputView.repeat()) {
                    gameService.setRandomNumber(game);
                } else {
                    break;
                }
            }
        }
    }
}
