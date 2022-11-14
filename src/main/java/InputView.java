import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static List<String> input() {
        System.out.print("숫자를 입력해 주세요 : ");
        final String s = scanner.nextLine();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            result.add(String.valueOf(s.charAt(i)));
        }
        return result;
    }
}
