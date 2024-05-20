package input;

import utils.ConstantUtils;

import java.util.Scanner;

public class InputViewService {

    public int[] processInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String [] input = scanner.nextLine().split("");
        int[] inputInt = new int[input.length];

        if(inputInt.length != ConstantUtils.GAME_NUM_LENGTH) {
            throw new IllegalArgumentException("숫자 3개만 입력 가능합니다. ");
        }

        for(int i = 0; i < ConstantUtils.GAME_NUM_LENGTH; i++) {
            inputInt[i] = parseToInteger(input[i]);
        }

        return inputInt;
    }

    private Integer parseToInteger(String strInt) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력해주세요. ");
        }
    }

}
