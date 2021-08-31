package view;

import dto.RoundInputDto;

import java.util.Scanner;

public class RoundInputConsoleView implements RoundInputView {
    public static final String DELIMITER = "";
    private final Scanner scanner;

    private RoundInputConsoleView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public static RoundInputView from(final Scanner scanner) {
        return new RoundInputConsoleView(scanner);
    }

    public RoundInputDto roundUserInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        String userInput = scanner.nextLine();
        String[] userInputToken = userInput.split(DELIMITER);
        return RoundInputDto.from(userInputToken);
    }
}
