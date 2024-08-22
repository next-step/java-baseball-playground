package baseballgame;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {

    Scanner scanner = new Scanner(System.in);
    public int[] inputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String[] inputNumber = scanner.next().split("");

        return Arrays.stream(inputNumber)  // String[]를 Stream<String>으로 변환
                .mapToInt(Integer::parseInt) // 각 문자열을 int로 변환
                .toArray();
    }
}
