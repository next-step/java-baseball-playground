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

    public HashSet<Integer> answerNumbers() {

        HashSet<Integer> randomNumbers = new HashSet<>();

        Random random = new Random();

        while (randomNumbers.size() < 3) {
            randomNumbers.add(random.nextInt(9));
        }

        return randomNumbers;
    }

    public void selectGame() {

        Scanner scanner = new Scanner(System.in);
        boolean isLoop = true;
        System.out.println(answerNumbers());
        startGame(scanner);
        scanner.close();
    }



    private boolean startGame(Scanner scanner) {
        List<Boolean> result = new ArrayList<Boolean>();
        
        System.out.println("숫자를 입력해주세요");
        String userInput = scanner.nextLine();
        System.out.printf("숫자를 입력해주세요 : %s \n", userInput);
        Iterator<Integer> iter = answerNumbers().iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        String[] numbers = userInput.split("");
        for (String number : numbers) {
            System.out.println(number);
            
        }
        System.out.println(result);
        
        return true;
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
