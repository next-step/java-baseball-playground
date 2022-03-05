package NumberBaseballGame;

public class Main {
    public static void main(String[] args) {
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.makeNumbers();
        InputView inputView = new InputView();
        inputView.printMessage();
        NumberChecker numberChecker = new NumberChecker();
        ResultView resultView = new ResultView();
        while(numberChecker.getStrikeCount() < 3)
        {
            UserNumber userNumber = new UserNumber(inputView.inputNumbers());
            numberChecker = new NumberChecker();
            numberChecker.checkNumber(computerNumber.getComputerNumbers(), userNumber.getUserNumbers());
            resultView.printMessage(numberChecker);
        }

    }

}
