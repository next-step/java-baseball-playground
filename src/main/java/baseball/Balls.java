package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> ballList;

    public Balls(NumberSupplier numberSupplier) {
        this.ballList = mapNumberToBallList(numberSupplier);
    }

    public List<Ball> mapNumberToBallList(NumberSupplier numberSupplier) {
        List<Ball> result = new ArrayList<>();
        List<Integer> numbers = numberSupplier.getNumberList();
        for (int i = 0; i < numbers.size(); i++) {
            result.add(new Ball(i + 1, numbers.get(i)));
        }
        return result;
    }

    public List<Ball> getBallList() {
        return ballList;
    }
}
