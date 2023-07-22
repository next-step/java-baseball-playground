package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {

    public void startGame() {
        System.out.println("게임을 시작합니다.");
        CreateNumber createNumber = new CreateNumber();
        CheckNumber checkNumber = new CheckNumber();
        List<Integer> computerNumberList;
        int result = 0;
        computerNumberList = createNumber.makeRandomNumbers();
        while(result != 30){
            String inputNumber = inputNumber();
            int[] userNumberArray = splitNumber(inputNumber);
            result = checkNumber.checkNumber(computerNumberList,userNumberArray);
            System.out.println(result%10 + "볼" + result/10 + "스트라이크");
        }
    }

    public void endGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String inputNumber(){
        System.out.println("세자리 숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        try {
            input = scanner.nextInt();
        }catch (Exception e){
            System.out.println("문자열 말고 숫자만 입력 가능합니다.");
        }
        if(input < 100 || input > 999){
            System.out.println("3자리 숫자만 입력 가능합니다. ");
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
