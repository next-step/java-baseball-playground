package stringCalculator;

import java.util.Scanner;

public class StringInput {
    //문자 입력받기
    public String inputStr() {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();

        return string;
    }
}
