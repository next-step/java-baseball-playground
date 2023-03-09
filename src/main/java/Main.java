import baseball.Balls;
import baseball.BaseBallResult;
import baseball.ComputerNumbers;
import baseball.InputView;
import baseball.util.ValidationUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String endFlag = "1";
        while (endFlag.equals("1")) {
            ComputerNumbers computerNumbers = new ComputerNumbers(3);
            Balls computerBalls = new Balls(computerNumbers.getResult());

            boolean isSuccess = false;
            while (!isSuccess) {
                InputView inputView = new InputView();
                Balls userBalls = new Balls(inputView.scanUserNumber());

                BaseBallResult result = computerBalls.play(userBalls);
                System.out.println(result.toStringResult());
                isSuccess = result.isSuccess();
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            endFlag = scanner.nextLine();
        }
    }
}
