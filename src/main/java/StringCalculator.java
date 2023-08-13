import java.util.Arrays;
import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        System.out.println(Arrays.toString(values));

        /**
         * "2 + 3 * 4 / 2"
         *
         */


        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                if (i == 0) {
                    sum += Integer.parseInt(values[0]);
                }

            } else {
                switch (values[i]) {
                    case "+" : sum += Integer.parseInt(values[i  + 1]);
                    break;
                    case "-" : sum -= Integer.parseInt(values[i  + 1]);
                    break;
                    case "*" : sum *= Integer.parseInt(values[i + 1]);
                    break;
                    case "/" : sum /= Integer.parseInt(values[i + 1]);
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
