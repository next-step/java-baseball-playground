package stringCalculator;

public class Calculator {

    //계산
    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
    public int mul(int a, int b) { return a * b; }
    public int div(int a, int b) {
        try{
            return a / b;
        }
        catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없다.");
        }
        return 0;
    }
}
