package baseballgame.domain.view;

public class InputValidator {
    public static void checkInput(String line) throws RuntimeException {
        trialCountNotNumericValueException(line);
        trialCountZeroException(line);
    }

    private static void trialCountNotNumericValueException(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("숫자를 입력해 주세요.");
        }
    }

    private static void trialCountZeroException(String line) {
        if (Integer.parseInt(line) <= 0) {
            throw new RuntimeException("숫자는 음수나 0이 될 수 없습니다.");
        }
    }
}
