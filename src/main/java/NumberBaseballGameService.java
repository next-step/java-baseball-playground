import gameResult.GameResult;
import gameResult.GameResultVerifyService;
import answer.ComputerAnswerService;
import answer.ComputerAnswerServiceImpl;
import input.InputViewService;

import static gameResult.GameResult.createDefaultGameResult;

public class NumberBaseballGameService {

    void playOneGame() {

        // 3자리 서로다른 수 생성
        ComputerAnswerService computerAnswerService = new ComputerAnswerServiceImpl();
        int[] computeAnswer = computerAnswerService.makeAnswer();

        InputViewService inputViewService = new InputViewService();
        GameResultVerifyService inputAnswerVerifyService = new GameResultVerifyService();
        GameResult gameResult = createDefaultGameResult();

        while(!gameResult.isWin()) {
            // 입력받기
            int[] input = inputViewService.processInput();

            // 결과판단
            gameResult = inputAnswerVerifyService.verify(computeAnswer, input);
            gameResult.printGameResult();

        }
    }
}
