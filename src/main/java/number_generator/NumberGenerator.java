package number_generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {
    public String generateNumber() {
        List<Integer> integers = IntStream.range(1, 10)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(integers);

        return integers.stream()
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
