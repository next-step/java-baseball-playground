package study.calculatorNew;

public class AddStrategy implements CalculatorStrategy{
    @Override
    public int calculator(int a, int b) {
        return a + b;
    }
}
