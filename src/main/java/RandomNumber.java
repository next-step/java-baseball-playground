import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumber {
    private final Random random = new Random();

    // 1~9 사이의 서로다른 3가지의 수로 이루어진 문자열을 리턴
    public String getRandomNumber() {
        return random.ints(1,10)
                .distinct()
                .limit(3)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}
