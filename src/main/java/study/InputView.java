package study;

import java.util.Scanner;

public class InputView {
    public static int[] takeInput() {
        int[] inputs = new int[3];
        System.out.println("숫자를 입력해 주세요.: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            inputs[0] = input / 100;
            inputs[1] = (input / 10) % 10;
            inputs[2] = input % 10;
        }
        return inputs;
    }
}
