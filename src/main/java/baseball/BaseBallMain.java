package baseball;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class BaseBallMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseBall baseBall = new BaseBall();

        while(true){
            System.out.print("숫자를 입력해 주세요 : ");
            int[] input = Stream.of(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

            JudgeCase judgeCase = baseBall.judge(input);
            if(judgeCase.getStrike() == 3){
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int game = sc.nextInt();
                sc.nextLine();
                if (game == 2){
                    return;
                }
                baseBall.resetValue();
            } else{
                if(judgeCase.getBall() > 0){
                    System.out.print(judgeCase.getBall()+"볼");
                }
                if (judgeCase.getStrike() > 0){
                    System.out.print(judgeCase.getStrike()+"스트라이크");
                }
                System.out.println();
            }
        }

    }
}
