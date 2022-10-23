package baseball;

import utils.ListGenerator;
import utils.ValidationUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Prompt {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final ValidationUtils validationUtils = new ValidationUtils();
    private final ListGenerator listGenerator = new ListGenerator();


    private List<Integer> askNumbers() throws IOException {
        System.out.print("숫자를 입력하세요 : ");
        String userInput = br.readLine();
        List<Integer> numbers = listGenerator.mapToList(userInput);

        if (!validationUtils.validateDigit(numbers))
            return null;

        return numbers;
    }

    public void printResult(Balls answer) throws IOException {
        PlayResult result = new PlayResult();
        while (result.getStrike() < 3) {
            result = handleNullPointerException(answer, result);
        }
    }

    private PlayResult handleNullPointerException(Balls answer, PlayResult result) throws IOException {
        try {
            List<Integer> validNumbers = askNumbers();
            result = answer.play(validNumbers);
            System.out.println(result.toString());
        } catch (NullPointerException e) {
            System.out.println("중복이 없는 3자리 숫자를 입력해 주세요.");
        }

        return result;
    }

    public int askAgain() throws IOException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");

        return Integer.parseInt(br.readLine());
    }
}
