import baseball.Balls;
import baseball.BaseBallResult;
import baseball.ComputerNumbers;
import baseball.util.ValidationUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputerNumbers computerNumbers = new ComputerNumbers(3);
        Balls computerBalls = new Balls(computerNumbers.getResult());
        while (true){
            System.out.print("숫자를 입력해 주세요 : ");
            String txt = scanner.nextLine();
            boolean isNumber = ValidationUtils.isNumber(txt);
            if( !isNumber ){
                System.out.println("숫자가 아닌값이 들어왔습니다");
                continue;
            }

            List<Integer> numberList = Arrays.stream(txt.split(""))
                    .map(i->Integer.parseInt(i))
                    .collect(Collectors.toList());
            boolean isDuplication = ValidationUtils.isDuplicationNumber(numberList);
            if( isDuplication ){
                System.out.println("같은 숫자가 입력되었습니다.");
                continue;
            }

            if( numberList.size() != 3 ){
                System.out.println("숫자 3개를 입력해주세요.");
                continue;
            }
            Balls userBalls = new Balls(numberList);



            BaseBallResult result = computerBalls.play(userBalls);
            System.out.println(result.toStringResult());

            if( !result.isSuccess() ){
                continue;
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String endValue = scanner.nextLine();
            if( endValue.equals("2") ){
                break;
            }

            computerNumbers = new ComputerNumbers(3);
            computerBalls = new Balls(computerNumbers.getResult());
        }

    }
}
