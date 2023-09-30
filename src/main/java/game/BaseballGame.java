package game;

import checker.BaseballChecker;
import checker.CountVO;
import number_generator.NumberGenerator;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class BaseballGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public BaseballGame(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void game() throws IOException {
        outputView.printGetInputNumbers();
        guessUntilCorrect();
        outputView.moreGame();
        if (inputView.getInput()) game();
    }

    private void guessUntilCorrect() throws IOException {
        String targetNumber = numberGenerator.generateNumber();
        BaseballChecker checker = new BaseballChecker(targetNumber);
        guess(checker);
    }

    private void guess(BaseballChecker checker) throws IOException {
        CountVO countVO = new CountVO();
        while (!countVO.isCorrect()){
            String input = inputView.getNumericInput();
            if (!outputView.validCheck(input)) continue;
            // 여기서 인덴트가 2가 되는데, VO가 상태를 추가로 가지게 되는 것보다는 위와 같은 형식이 더 자연스럽다고 판단함
            checker.evaluateGuess(input);
            countVO = checker.getResult();
            outputView.printResult(countVO);
        }
    }
}
