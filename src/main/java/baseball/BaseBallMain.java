package baseball;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaseBallMain {

    public static String[] computerRandomNumbers = new String[3];
    public static String[] userRandomNumbers = new String[3];

    public static int ballNum = 0;
    public static int strike = 0;
    public static boolean isReturnGame = true;
    public static int isReturnNumber = 0;
    public static Scanner sc = new Scanner(System.in);

    public static String inputValue() {
        return sc.next();
    }

    public static void getComputerRandomNumbers() {
        for(int i = 0; i < computerRandomNumbers.length;i++) {
            computerRandomNumbers[i] = String.valueOf((int)(Math.random() * 9) + 1);
            for(int j = 0; j < i; j++) {
                if(computerRandomNumbers[i].equals(computerRandomNumbers[j])) {
                    i--;
                }
            }
        }
        getComputerRandomNumbersTrans(computerRandomNumbers);
    }

    public static void getComputerRandomNumbersTrans(String[] computerRandomNumbers) {
        String resComputerRandomNumbers = Arrays.stream(BaseBallMain.computerRandomNumbers).collect(Collectors.joining());
        print(resComputerRandomNumbers);
    }

    public static void characterComparison(String userInputNumbers) {
        for(int i = 0; i < computerRandomNumbers.length;i++) {
            if(userInputNumbers.contains(computerRandomNumbers[i])) {
                indexNumberComparison(userInputNumbers.indexOf(computerRandomNumbers[i]),i);
            }
        }
    }

    public static void indexNumberComparison(int indexNumbers, int i ) {
        if( indexNumbers == i ) {
            strike++;
        } else {
            ballNum++;
        }
    }

    public static void numberBaseBallIsBoolean() {
        if( strike == 3 ) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isReturnNumber = Integer.parseInt(inputValue());
            gameChoiceNumbers(isReturnNumber);
        }
    }

    public static void gameChoiceNumbers(int isReturnNumber) {
        if(isReturnNumber == 2) {
            isReturnGame = false;
            return;
        }
        getComputerRandomNumbers();
    }

    public static void print(String resComputerRandomNumbers) {
        System.out.println("컴퓨터 :" + resComputerRandomNumbers);
    }

    public static void main(String[] args) {
        getComputerRandomNumbers();

        String userInputNumber = "";

        while ( isReturnGame ) {
            System.out.print("숫자를 입력해 주세요 : ");
            String inputNum = inputValue();
            characterComparison(inputNum);
            System.out.println(ballNum + "볼 " + strike + "스트라이크");
            numberBaseBallIsBoolean();
            ballNum = 0;
            strike = 0;
        }
    }
}
