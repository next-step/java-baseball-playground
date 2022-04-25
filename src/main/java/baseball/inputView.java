package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputView {

    private static Scanner scanner = new Scanner(System.in);

    public static Balls userInput() {
        List<Integer> result = new ArrayList<>();
        System.out.print("숫자를 입력해 주세요 : ");
        String num = scanner.nextLine();
        String[] split = num.split("");
        for (int i = 0; i < split.length; i++) {
            result.add(Integer.parseInt(split[i]));
        }

        return new Balls(result);
    }
}
