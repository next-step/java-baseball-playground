package study.calculatorNew;

// 전략패턴을 이용하여 객체간의 의존성을 낮춰준다.
public interface CalculatorStrategy {
    int calculator(int a, int b );
}
