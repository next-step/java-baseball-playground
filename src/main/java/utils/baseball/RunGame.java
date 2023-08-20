package utils.baseball;

public class RunGame {
    public static void main(String[] args){
        boolean run = true;
        BullsAndCows game = BullsAndCows.makeNewGame();
        game.resetComputerNumbers();

        while(run) {
            String inputValue = PlayerInput.getInputNumber();
            game.progressGameRound(inputValue);
            ResultView.printGameResult(game);
            if (game.isAllStrike()) {
                String selectedOption = PlayerInput.getInputGameOption();
                game.handleReplayGame(selectedOption);
                run = game.shouldReplayGame(selectedOption);
            }
        }
    }

}
