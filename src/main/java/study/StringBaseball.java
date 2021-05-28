package study;

import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringBaseball {
    public static void main(String[] args) {
        List<Integer> numbers = getNumbers();
        for (Integer number : numbers) {
            System.out.println(number);
        }
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
