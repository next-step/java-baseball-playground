package baseballgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputNumber {
    public String inputUserNum() {
        System.out.println("1~9 중복없는 세자리 숫자를 입력해주세요");
        return new Scanner(System.in).nextLine();
    }
    public static ArrayList validNum(String number) {
       if(isSingleDigitNum(number) && isUnique(number) && isThreeDigits(number)) {
            return addList(parsing(number));
       }
       return null;
    }

    private static String[] parsing(String number) {
        return number.split("");
    }
    private static ArrayList addList (String [] numbers) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add(Integer.parseInt(numbers[i]));
        }
        return list;
    }

    public static boolean isSingleDigitNum (String number) {
        if (isNum(number)) {
            return isOneDigit(number);
        }
        return false;
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

    public static boolean isUnique(String number) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char ch : number.toCharArray()) {
            if (!uniqueChars.add(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isThreeDigits (String number) {
        if (number.length() == 3) {
            return true;
        }
        return false;
    }



}
