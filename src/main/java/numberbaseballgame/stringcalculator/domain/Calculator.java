package numberbaseballgame.stringcalculator.domain;

public class Calculator {

    UserInputReader userInputReader = new UserInputReader();

    private int result;

    // 계산을 차례대로 진행한다
    int performCalculate(){
        // 초기값을 설정한다
        // 계산을 반복해서 진행한다
        // 계산한 총 값을 반환한다
        return 0;
    }

    // 초기값을 설정한다
    void setInitial() {
        this.result = Integer.parseInt(userInputReader.getUserInput().get(0));
    }

    // 계산을 반복해서 수행한다
    private void IterateCalculate() {
        for (int i = 1; i < userInputReader.getUserInput().size(); i+=2) {
            // 계산을 한다
            calculateTo(userInputReader.getUserInput().get(i), Integer.parseInt(userInputReader.getUserInput().get(i + 1)));
        }
    }

    // 계산을 한다
    private void calculateTo(String calculateType, int operand) {
        this.result = CalculateType.fromSymbol(calculateType).calculate(this.result, operand);
    }

}
