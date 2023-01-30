package baseball;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaseBallMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] computerRandomNumbers = new String[3];
        String computerRandomNumber = "";

        for(int i = 0; i < computerRandomNumbers.length;i++) {
            computerRandomNumbers[i] = String.valueOf((int)(Math.random() * 9) + 1);
        }

        computerRandomNumber = Arrays.stream(computerRandomNumbers)
                .collect(Collectors.joining());

        System.out.println(" 컴퓨터 : " + computerRandomNumber);

        String[] userInputNumbers = new String[3];
        String userInputNumber = "";

        int indexNumbers = 0;

        int ballNum = 0;
        int strike = 0;

        int isReturnNumber = 0;

        boolean isReturnGame = true;

        while ( isReturnGame ) {

            System.out.print("숫자를 입력해 주세요 : ");
            userInputNumber = sc.next();

            if(userInputNumber.contains(computerRandomNumbers[0])) {
                indexNumbers = userInputNumber.indexOf(computerRandomNumbers[0]);
                if( indexNumbers == 0 ) {
                    strike++;
                } else if( indexNumbers != 0 ) {
                    ballNum++;
                }
            }
            if(userInputNumber.contains(computerRandomNumbers[1])) {
                indexNumbers = userInputNumber.indexOf(computerRandomNumbers[1]);
                if( indexNumbers == 1 ) {
                    strike++;
                } else if( indexNumbers != 1 ) {
                    ballNum++;
                }
            }
            if(userInputNumber.contains(computerRandomNumbers[2])) {
                indexNumbers = userInputNumber.indexOf(computerRandomNumbers[2]);
                if( indexNumbers == 2 ) {
                    strike++;
                } else if( indexNumbers != 2 ) {
                    ballNum++;
                }
            }
            if( userInputNumber.contains(computerRandomNumbers[0]) && userInputNumber.contains(computerRandomNumbers[1]) &&
                    userInputNumber.contains(computerRandomNumbers[2])){
                ballNum = 3;
            }

            if( strike == 3 ) {
                System.out.println(ballNum + "볼 " + strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                isReturnNumber = sc.nextInt();

                if(isReturnNumber == 2) {
                    isReturnGame = false;
                    break;
                } else if( isReturnNumber == 1 ){
                    for(int i = 0; i < computerRandomNumbers.length;i++) {
                        computerRandomNumbers[i] = String.valueOf((int)(Math.random() * 9) + 1);
                    }
                    computerRandomNumber = Arrays.stream(computerRandomNumbers).collect(Collectors.joining());
                    System.out.println(" 컴퓨터 : " + computerRandomNumber);
                }

            } else if(strike != 3) {
                System.out.println(ballNum + "볼 " + strike + "스트라이크");
            }
            ballNum = 0;
            strike = 0;
        }
    }
}
