package study;

import java.util.Scanner;

public class StringCalc {

    public static void main(String[] args) {

        System.out.println("계산할 값 입력 : ");
        String[] values = new Scanner(System.in).nextLine().split(" ");

        int first = Integer.parseInt(values[0]);
        System.out.println(first);
        int result = first;

        for (int i = 1; i < values.length; i += 2) {
            String symbol = values[i];
            System.out.println(symbol);
            int second = Integer.parseInt(values[i + 1]);
            System.out.println(second);

            result = Calc.calculate(result, symbol, second);
        }
        Output.print(result);
    }
}
