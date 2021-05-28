package study;

import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StringBaseball {
    public static void main(String[] args) {
        List<Integer> numbers = getNumbers();
        String[] inputs = getUserInput();
    }

    private static String[] getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split("");
    }

    private static List<Integer> getNumbers() {
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
