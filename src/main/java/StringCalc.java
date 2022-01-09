import baseball2.domain.Judgment;
import baseball2.domain.NumberGenerator;
import baseball2.domain.Referee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringCalc {

    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> computer = generator.createRandomMembers();
        Referee referee = new Referee();
        String result = "";
        while (!result.equals("0 볼 3 스트라이크")) {
            result = referee.compare(computer, askNumbers());
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static List<Integer> askNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요");
        String input = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split("")){
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }
}
