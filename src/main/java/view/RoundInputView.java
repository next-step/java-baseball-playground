package view;

import dto.RoundInputDto;

import java.util.Scanner;

import static java.lang.System.out;

public class RoundInputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String DELIMETER = "";

    private RoundInputView() {
    }

    public static RoundInputDto roundUserInput() {
        out.print("숫자를 입력해 주세요 : ");
        String userInput = SCANNER.nextLine();
        String[] userInputToken = userInput.split(DELIMETER);
        return RoundInputDto.from(userInputToken);
    }
}
