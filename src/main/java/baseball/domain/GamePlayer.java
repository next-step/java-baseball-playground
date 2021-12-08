package baseball.domain;

import java.util.List;
import java.util.Scanner;

import static baseball.Application.receiveInputFromUser;

public class GamePlayer {
    public int playGame() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> comNums = numberGenerator.makeThreeNumbersByCom();
        Referee referee = new Referee();

        String answer = "";
        while (!answer.equals("3스트라이크")) {
            answer = referee.compare(comNums, receiveInputFromUser());
            System.out.println(answer);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return Integer.parseInt(input);
    }
}
