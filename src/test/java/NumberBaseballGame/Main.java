package NumberBaseballGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int index = 1;
        while(index != 2)
        {
            ComputerNumber computerNumber = new ComputerNumber();
            computerNumber.makeNumbers();
            InputView inputView = new InputView();
            NumberChecker numberChecker = new NumberChecker();
            ResultView resultView = new ResultView();
            while(numberChecker.getStrikeCount() < 3)
            {
                inputView.printMessage();
                UserNumber userNumber = new UserNumber(inputView.inputNumbers());
                numberChecker = new NumberChecker();
                numberChecker.checkNumber(computerNumber.getComputerNumbers(), userNumber.getUserNumbers());
                resultView.printMessage(numberChecker);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            index = scanner.nextInt();
        }
    }

}
