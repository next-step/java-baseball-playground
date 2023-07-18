package baseballgame;

import java.util.ArrayList;
import java.util.Scanner;

public class InputNumber {
    public String inputUserNum() {
        System.out.println("1~9 중복없는 세자리 숫자를 입력해주세요");
        return new Scanner(System.in).nextLine();
    }
//    public static ArrayList validNum(String number) {
//       if(isNum(number) && isDuplicate(number) && isThreeDigit(number)) {
//            ArrayList list = addList(parsing(number));
//       }
//    }

    private static String[] parsing(String number) {
        return number.split("");
    }
    private static ArrayList addList (String [] numbers) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add(numbers[i]);
        }
        return list;
    }

    public static boolean isDigitNum (String number) {
        boolean digitNum = false;
        if (isNum(number)) {
            digitNum = isOneDigit(number);
        }
        return digitNum;
    }

    private static boolean isNum (String number) {
        try{
            Integer.parseInt(number);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private static boolean isOneDigit(String number) {
        for (int i=0; i<number.length(); i++) {
            char num = number.charAt(i);
            if(!isOneToNine(num)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOneToNine (char num) {
        if ('1'<=num && num<='9') {
            return true;
        }
        return false;
    }
}
