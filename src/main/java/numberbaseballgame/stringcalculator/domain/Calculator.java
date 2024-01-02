package numberbaseballgame.stringcalculator.domain;

public class Calculator {

    UserInputReader userInputReader = new UserInputReader();

    int result = 0;

    // 사칙연산을 수행한다.
    public int perform() {
        setInitial();

        return result;
    }

    // 첫번째 숫자를 initial값으로 설정한다.
    public void setInitial() {
        userInputReader.read();
        this.result = userInputReader.numbers.get(0);
    }

    // 숫자와 연산기호를 순서대로 반복한다.
    public int repeatCalculate() {

        return 0;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.perform());
    }

}
