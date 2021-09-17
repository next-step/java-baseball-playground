package study.basball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import study.basball.domain.NumberGenerator;
import study.basball.domain.Referee;

public class Application {


    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        HashSet<Integer> computerNumbers = numberGenerator.createRandomNumbers();
        System.out.println(numberGenerator.createRandomNumbers());
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요 : ");
        String playerInput = scanner.nextLine();
        System.out.printf("숫자를 입력해주세요 : %s\n", playerInput);
        
        String[] Numbers = playerInput.split("");
        
        List<Integer> playerNumbers = new ArrayList<>();
        int i = 0;
        while(playerNumbers.size() < 3){
            playerNumbers.add(Integer.parseInt(Numbers[i++]));
        }

        String answer = Referee.compare(computerNumbers, playerNumbers);
        System.out.println(answer);
        
        if(answer.equals("3 스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        } else if(answer.equals("2 스트라이크")) {
            System.out.println("2 스트라이크 입니다.");
        } else {
            System.out.println("1 스트라이크 입니다.");
        }
        scanner.close();
    }

}
