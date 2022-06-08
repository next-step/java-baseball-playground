package stringCalculator;

import java.util.LinkedList;
import java.util.Queue;

public class Numbers {
    private final Queue<Integer> numbers;

    public Numbers(String[] split) {
        numbers = new LinkedList<>();
        setNumbers(split);
    }
    private void setNumbers(String[] split) {
        for (int i = 2; i < split.length; i += 2) {
            numbers.add(Integer.parseInt(split[i]));
        }
    }
    public Integer poll() {
        return numbers.poll();
    }

    public boolean isEmpty() {
        return numbers.isEmpty();
    }
}
