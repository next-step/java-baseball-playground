package study.calculatorNew;

import java.util.Scanner;

public class CalculatorNew {

    CalculatorStrategy calculatorStrategy;

    CalculatorNew(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public int returnResult(int a, int b) {
        return calculatorStrategy.calculator(a, b);
    }

}
