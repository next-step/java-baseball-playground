package training1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String value = sc.nextLine();
        String[] values = value.split(" ");

        StringCalculator stringCalculator = new StringCalculator();

        System.out.println(stringCalculator.getResult(values));
    }
}
