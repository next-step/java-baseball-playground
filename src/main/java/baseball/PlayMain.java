package baseball;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlayMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        while(play){
            RandomNumber randomNumber = new RandomNumber();
            Balls balls = new Balls(randomNumber.getValue());

            while(true){
                System.out.println("숫자를 입력해 주세요 : ");
                String[] input = sc.nextLine().split("");
                Balls input_balls = new Balls(Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList()));
                PlayResult playResult = balls.play(input_balls);

                playResult.printResult();
                if(playResult.getStrike() == 3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    if(sc.nextInt() == 2){
                        play = false;
                        break;
                    }
                    sc.nextLine();
                    break;
                }
            }
        }
    }
}
