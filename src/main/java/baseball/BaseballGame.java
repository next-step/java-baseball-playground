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
            String inputNumber = checkNumber.inputNumber();
            int[] userNumberArray = checkNumber.splitNumber(inputNumber);
            result = checkNumber.checkNumber(computerNumberList,userNumberArray);
            System.out.println(result%10 + "볼" + result/10 + "스트라이크");
        }
    }

    public void endGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void reGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 1){
            startGame();
        }
        if(input == 2){
            endGame();
        }
    }




}
