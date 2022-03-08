package Calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열 계산기");
        System.out.println("숫자와 사칙연산을 스페이스바를 이용하여 분리해서 입력하세요.");
        String formula = scanner.nextLine();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(new Formula(formula).getFormula());
        System.out.println(result);
    }
}
