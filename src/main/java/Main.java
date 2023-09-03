
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        //1. 난수 생성
        LinkedHashSet<Integer> randomNums = _getRandomNums();
    }

    private static LinkedHashSet<Integer> _getRandomNums() {
        RandomGenerator rdGenerator = new RandomGenerator();
        return rdGenerator.createRandomNums();
    }
}
