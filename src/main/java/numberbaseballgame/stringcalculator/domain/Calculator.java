package numberbaseballgame.stringcalculator.domain;

import java.util.List;

public class Calculator {

    private final UserInputReader userInputReader;

    private int result;

    public Calculator(UserInputReader userInputReader) {
        this.userInputReader = userInputReader;
    }

    // 계산을 차례대로 진행한다
    public int performCalculate() {
        // 초기값을 설정한다
        setInitial();
        // 계산을 반복해서 진행한다
        IterateCalculate();
        // 계산한 총 값을 반환한다
        return result;
    }

    // 초기값을 설정한다
    private void setInitial() {
        this.result = Integer.parseInt(userInputReader.getUserInput().get(0));
    }

    // 계산을 반복해서 수행한다
    private void IterateCalculate() {
        List<String> inputs = userInputReader.getUserInput();
        for (int i = 1; i < inputs.size(); i += 2) {
            // 계산을 한다
            String caculatorType = inputs.get(i);
            int operand = Integer.parseInt(inputs.get(i + 1));
            calculateTo(caculatorType, operand);
        }
    }

    // 계산을 한다
    private void calculateTo(String calculateType, int operand) {
        this.result = CalculateType.fromSymbol(calculateType).calculate(this.result, operand);
    }

}
