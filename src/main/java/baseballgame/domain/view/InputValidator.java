package baseballgame.domain.view;

public class InputValidator {
    private static final int BALL_SIZE = 3;
    public static void checkInput(String line) throws RuntimeException {
        NotNumericValueException(line);
        inputZeroException(line);
        inputSizeException(line);
    }

    private static void inputSizeException(String line) {
        if( line.length() != 3){
            throw new RuntimeException("숫자는 세자리 꼭 세자리여야만 합니다");
        }
    }

    private static void NotNumericValueException(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("숫자를 입력해 주세요.");
        }
    }

    private static void inputZeroException(String line) {
        if (Integer.parseInt(line) <= 0) {
            throw new RuntimeException("숫자는 음수나 0이 될 수 없습니다.");
        }
    }

    public static int checkInt(int input) throws RuntimeException {
        if (input != 1 && input != 2) {
            throw new RuntimeException("1 이나 2 를 입력해주세요");
        }
        return input;
    }
}
