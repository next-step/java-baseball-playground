package study;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringCalculator cal = new StringCalculator();

        String str = sc.nextLine();
        String[] strs = cal.split(str);

        int result = cal.calculateString(strs);

        System.out.println(result);
    }
}
