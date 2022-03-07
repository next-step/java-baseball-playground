package unit_test_sample;

public class Calculator {

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.add(3, 5));

        System.out.println(cal.subtract(5, 6));
        System.out.println(cal.multiply(2, 6));
        System.out.println(cal.divide(8, 4));

    }


    int add(int i, int j){
        return i + j;
    }

    int subtract(int i, int j){
        return i - j;
    }

    int multiply(int i, int j){
        return i * j;
    }

    int divide(int i, int j){
        return i/j;
    }

}
