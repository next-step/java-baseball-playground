import baseball2.domain.NumberGenerator;

import java.util.List;

public class StringCalc {

    public static void main(String[] args) {
        final NumberGenerator numberGenerator = new NumberGenerator();
        final List<Integer> numbers = numberGenerator.createRandomMembers();
        System.out.println(numbers);
    }
}
