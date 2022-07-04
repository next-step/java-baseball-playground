package study;

import java.util.Scanner;

public class StringCalculator {

    private ScannerUtil scanner;

    public interface ScannerUtil {
        String nextLine();
    }

    public class CalculatorScanner implements ScannerUtil {

        @Override
        public String nextLine() {
            return new Scanner(System.in).nextLine();
        }
    }

    public StringCalculator() {
        scanner = new CalculatorScanner();
    }

    public void setScanner(ScannerUtil scannerUtil) {
        scanner = scannerUtil;
    }

    public String inputFormula() {
        return scanner.nextLine();
    }

    public String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    public int calculateSimple(int left, String operator, int right) {
        int result = 0;
        if ("+".equals(operator)) {
            result = left + right;
        } else if ("-".equals(operator)) {
            result = left - right;
        } else if ("*".equals(operator)) {
            result = left * right;
        } else if ("/".equals(operator)) {
            if (right == 0) {
                throw new IllegalArgumentException("Division by zero");
            }
            result = left / right;
        } else {
            throw new IllegalArgumentException("Operator[" + operator + "] is not supported operator");
        }
        return result;
    }

    public int calculate(String[] units) {
        int lhs = 0;
        String operator = "";
        int rhs = 0;
        int index = 0;

        lhs = Integer.parseInt(units[index]);
        index++;

        while (index < units.length) {
            operator = units[index];
            index++;

            rhs = Integer.parseInt(units[index]);
            index++;

            lhs = calculateSimple(lhs, operator, rhs);
        }

        return lhs;
    }
}
