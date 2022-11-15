import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private Scanner scanner;
    private ResultView resultView;

    public InputView() {
        scanner = new Scanner(System.in);
        resultView = new ResultView();
    }


    public List<String> input() {
        resultView.inputNumbers();
        List<String> result = new ArrayList<>();

        while (true) {
            final String s = scanner.nextLine();
            if (ValidateUtil.isLengthNot3(s)) {
                resultView.threeNumbers();
                continue;
            }

            for (int i = 0; i < 3; i++) {
                result.add(String.valueOf(s.charAt(i)));
            }
            break;
        }

        return result;
    }
}
