package baseball;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberSupplier implements NumberSupplier {
    private final int totalNumber;

    public RandomNumberSupplier(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    // 조건에 맞추어 숫자를 반환하므로, 별도의 유효성 검사를 하지 않음
    @Override
    public List<Integer> getNumberList() {
        return new Random().ints(1, 10)
                .distinct()
                .limit(totalNumber)
                .boxed()
                .collect(Collectors.toList());
    }
}
