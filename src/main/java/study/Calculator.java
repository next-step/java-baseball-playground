package study;


public class Calculator {

    public int calc(int i, int j, String sign) {
        return switch(sign) {
            case "+" -> add(i, j);
            case "-" -> subtract(i, j);
            case "/" -> divide(i, j);
            case "*" -> multiply(i, j);
            default -> 0;
        };
    }
    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    public int multiply(int i, int j) {
        return i * j;
    }

    public int divide(int i, int j) {
        return  i / j;
    }

    public static void main(String[] args) {

    }
}


