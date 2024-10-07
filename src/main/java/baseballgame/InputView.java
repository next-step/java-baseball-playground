package baseballgame;

import util.ScannerUtil;

public class InputView {

    private final ScannerUtil scanner;

    public InputView(ScannerUtil scanner) {
        this.scanner = scanner;
    }

    public String[] input() {
        System.out.print("숫자를 입력해 주세요 : ");

        final String number = scanner.nextLine();

        validateInputLength(number);

        return number.split("");
    }

    private void validateInputLength(final String string) {
        if (string.length() != 3) {
            throw new RuntimeException("숫자는 반드시 3자리만 입력 해야 합니다.");
        }
    }

    public ScannerUtil getScanner() {
        return scanner;
    }
}
