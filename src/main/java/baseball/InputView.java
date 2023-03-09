package baseball;

import baseball.util.ValidationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private boolean isComplete = false;

    public List<Integer> scanUserNumber() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numberList = new ArrayList<>();
        while ( !isComplete ){
            System.out.print("숫자를 입력해 주세요 : ");
            String input = scanner.nextLine();

            boolean isNumber = ValidationUtils.isNumber(input);
            if( !isNumber ){
                System.out.println("숫자가 아닌값이 들어왔습니다");
                continue;
            }

            numberList = Arrays.stream(input.split(""))
                    .map(i->Integer.parseInt(i))
                    .collect(Collectors.toList());
            boolean isDuplication = ValidationUtils.isDuplicationNumber(numberList);
            if( isDuplication ){
                System.out.println("같은 숫자가 입력되었습니다.");
                continue;
            }

            if( numberList.size() != 3 ){
                System.out.println("숫자 3개를 입력해주세요.");
                continue;
            }
            isComplete = true;
        }
        return numberList;
    }

    public List<Integer> toList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
