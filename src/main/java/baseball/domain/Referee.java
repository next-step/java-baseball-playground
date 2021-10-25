package baseball.domain;

import java.util.List;
import java.util.Scanner;

public class Referee {

    public String compare (List<Integer> createdRandomNumbers, List<Integer> givenNumbersByUser) {

        Judgement judgement = new Judgement();

        // (스트라이크 + 볼)
        int correctCount = judgement.correctCount(createdRandomNumbers, givenNumbersByUser);

        // 스트라이크 갯수를 받아오면 되는거지? ( 스트라이크 )
        int strikeCount = judgement.getStrikeCount(createdRandomNumbers, givenNumbersByUser);

        // correctCount - 스트라이크카운트 = ( 볼 )
        int ball = correctCount - strikeCount;

        if (correctCount == 0)
            return "out";

        return ball + " 볼 " + strikeCount + " 스트라이크" ;
    }

    public boolean gameAgain() {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scan = new Scanner(System.in);

        String inputData = scan.next();

        if (inputData.equals("1"))
            return true;

        return false;
    }
}
