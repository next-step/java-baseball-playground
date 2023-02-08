package study.calculatorNew;

public class MultipleStategy implements CalculatorStrategy{
    @Override
    public int calculator(int a , int b) {
        return a * b;
    }
}
