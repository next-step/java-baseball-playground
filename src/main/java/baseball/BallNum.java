package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BallNum {

    private final String inNumber;
    public static final List<String> BALLS_POOL = Arrays.asList("1","2","3","4","5","6","7","8","9");

    BallNum(String inNumber) {
        this.inNumber = makeBallnum(inNumber);
    }

    public static String makeBallnum(String inNumber) throws IllegalArgumentException {
//        if (isInt(inNumber)) {
//            throw new IllegalArgumentException("isNotaNumber");
//        }
        if (!isInRange(inNumber)) {
            throw new IllegalArgumentException("isNotInRange");
        }
        return inNumber;
    }

    private static boolean isInRange(String inNumber) {
        return BALLS_POOL.contains(inNumber);
    }

    public String getInNumber() {
        return inNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNum ballNum = (BallNum) o;
        return Objects.equals(inNumber, ballNum.inNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inNumber);
    }
}
