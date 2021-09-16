package study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberBaseballGame {

    public void printMenu() {
        System.out.println("+------------------+");
        System.out.println("|게임 시작 > 1|");
        System.out.println("|게임 종료 >      2|");
        System.out.println("+------------------+");
    }

    public void selectGame() {

        Scanner scanner = new Scanner(System.in);
        boolean isLoop = true;

        List<Boolean> result = startGame(scanner);
        
        scanner.close();
    }



    private List<Boolean> startGame(Scanner scanner) {
        List<Boolean> result = new ArrayList<Boolean>();
        RandomNumbers randomNumbers = new RandomNumbers();
        System.out.println(randomNumbers.answerNumbers());
        System.out.println("숫자를 입력해주세요");
        String userInput = scanner.nextLine();
        System.out.printf("숫자를 입력해주세요 : %s \n", userInput);
        Iterator<Integer> iter = randomNumbers.answerNumbers().iterator();
        String[] numbers = userInput.split("");
        while(iter.hasNext()) {
//            System.out.println(iter.next());
            for (String number : numbers) {
//                System.out.println(number);
                if(iter.next() == Integer.parseInt(number)) {
                    result.add(true);
                } else {                    
                    result.add(false);
                }
            }
        }
        System.out.println(result);
        
        return result;
    }

    private boolean endGame() {
        System.out.println("게임이 종료되었습니다.");
        return false;
    }

    public static void main(String[] args) {
        NumberBaseballGame nbg = new NumberBaseballGame();

        nbg.selectGame();

    }

}
