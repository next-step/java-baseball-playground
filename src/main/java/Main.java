import tdd.Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String values = sc.nextLine();

        int result = Calculator.calculator(values);
        System.out.println("result = " + result);
    }
}
