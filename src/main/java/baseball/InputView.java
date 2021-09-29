package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {

    static Scanner sc = new Scanner(System.in);

    public static String input() {

        System.out.print("숫자를 입력해 주세요 : ");
        String number = sc.nextLine();

        return number;
    }
}
