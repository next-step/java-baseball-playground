package stringCalculator;

public class Calculator {

    private int result;
    private Numbers numbers;
    private Operators operators;


    public Calculator(String str) {
        String[] split = str.split(" ");
        this.numbers = new Numbers(split);
        this.operators = new Operators(split);
        this.result = Integer.parseInt(split[0]);
    }

    public int calculate() {
        while(!numbers.isEmpty()) {
            Integer number = numbers.poll();
            Operator operator = operators.poll();
            operate(operator, number);
        }
        return result;
    }

    private void plus(int number) {
        this.result += number;
    }

    private void minus(int number) {
        this.result -= number;
    }

    private void multiple(int number) {
        this.result *= number;
    }

    private void divide(int number) {
        this.result /= number;
    }

    private void operate(Operator operator, Integer number) {
        if (operator.isPlus()) {
            plus(number);
        }
        if (operator.isMinus()) {
            minus(number);
        }
        if (operator.isMultiple()) {
            multiple(number);
        }
        if (operator.isDivide()) {
            divide(number);
        }
    }
}
