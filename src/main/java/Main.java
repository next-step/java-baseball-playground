import baseball.Balls;
import baseball.MapComputerInput;
import baseball.PlayResult;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // 정답
        List<Integer> input_com = new MapComputerInput().mapComputerInput();

        while (true) {

            Balls balls = new Balls(input_com);

            Scanner sc = new Scanner(System.in);
            System.out.println("숫자를 입력해주세요: ");

            List<Integer> input_user = Arrays.stream(sc.nextLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // 게임
            PlayResult result = balls.play(input_user);
            System.out.println(result.toString());

            if (result.isGameEnd()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다.! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                if (!balls.again(sc.nextInt())) {
                    break;
                }

                input_com = new MapComputerInput().mapComputerInput();
            }
        }
    }
}


