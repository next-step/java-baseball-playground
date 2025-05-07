package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MapComputerInput {

    public List<Integer> mapComputerInput() {

        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) digits.add(i);
        Collections.shuffle(digits);

        int number = digits.get(0) * 100 + digits.get(1) * 10 + digits.get(2);

        return Arrays.stream(String.valueOf(number).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
