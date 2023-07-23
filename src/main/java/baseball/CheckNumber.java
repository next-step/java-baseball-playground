package baseball;

import java.util.List;
import java.util.Scanner;

public class CheckNumber {
    public int checkNumber(List<Integer> computerNumberList, int[] userNumber) {
        int result = 0;
        for(int i=0;i<userNumber.length;i++){
            result += isCorrect(computerNumberList,userNumber[i],i);
        }
        return result;
    }
    public int isCorrect(List<Integer> computerNumberList,int userNumber,int index) {
        if(!computerNumberList.contains(userNumber)){
            return 0;
        }
        if(computerNumberList.indexOf(userNumber) == index) {
            return 10;
        }
        if(computerNumberList.indexOf(userNumber) != index) {
            return 1;
        }
        return 0;
    }

    public String inputNumber(){
        System.out.println("세자리 숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        try {
            input = scanner.nextInt();
        }catch (Exception e){
            System.out.println("문자열 말고 숫자만 입력 가능합니다.");
            return inputNumber();
        }
        if(input < 100 || input > 999){
            System.out.println("3자리 숫자만 입력 가능합니다. ");
            return inputNumber();
        }
        return String.valueOf(input);
    }

    public int[] splitNumber(String userNumber){
        int[] numberArray = new int[3];
        for(int i=0;i<3;i++){
            numberArray[i] = Integer.parseInt(String.valueOf(userNumber.charAt(i)));
        }
        return numberArray;
    }

}
