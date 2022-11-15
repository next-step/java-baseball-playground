import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoNumber {

    public static List<String> makeLottoNumbers() {
        return new Random()
            .ints(1, 10)
            .boxed()
            .distinct()
            .limit(3)
            .map(m -> Integer.toString(m))
            .collect(Collectors.toList());
    }

}
