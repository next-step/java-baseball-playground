import baseball2.domain.Judgment;
import baseball2.domain.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class StringCalc {

    public static void main(String[] args) {
//        final NumberGenerator numberGenerator = new NumberGenerator();
//        final List<Integer> numbers = numberGenerator.createRandomMembers();
//        System.out.println(numbers);

        Judgment judgment = new Judgment();
        int count = judgment.correctCount(Arrays.asList(4, 5, 6), Arrays.asList(1, 2, 3));
        System.out.println(count);
    }
}
