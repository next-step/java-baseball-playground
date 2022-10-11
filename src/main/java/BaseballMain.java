import domain.NumberGenerator;

import java.util.List;

public class BaseballMain {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> numbers = generator.CreateRandomNumbers();
        System.out.println(numbers);
    }
}
