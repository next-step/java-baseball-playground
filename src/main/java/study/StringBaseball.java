package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StringBaseball {

    public void play() {
        List<Integer> numbers = getNumbers();
        int[] results;

        do {
            List<Integer> inputs = toIntegerList(getUserInput());
            results = getResult(numbers, inputs);
            printResults(results);
        } while (!isCorrect(results));

        gameOver();
    }

    private void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료.");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input==1) {
            play();
        }
    }

    private void printResults(int[] results) {
        System.out.printf("%d 아웃, ", results[0]);
        System.out.printf("%d 볼, ", results[1]);
        System.out.printf("%d 스트라이크\n", results[2]);
    }

    private boolean isCorrect(int[] results) {
        return results[2] == 3;
    }

    private int[] getResult(List<Integer> numbers, List<Integer> inputs) {
        int[] results = new int[3];
        for (int i = 0; i < inputs.size(); i++) {
            results[getCompareResult(numbers, inputs, i)]++;
        }
        return results;
    }

    private int getCompareResult(List<Integer> numbers, List<Integer> inputs, int i) {
        int result = 0;
        if (numbers.contains(inputs.get(i))) {
            result = 1;
            if (numbers.get(i).equals(inputs.get(i))) {
                result = 2;
            }
        }
        return result;
    }

    private List<Integer> toIntegerList(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(Integer.parseInt(input));
        }
        return numbers;
    }

    private String[] getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split("");
    }

    private List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size()<3) {
            int num = random.nextInt(10);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }
}
