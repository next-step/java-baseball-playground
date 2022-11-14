import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoNumber {

    public List<String> makeLottoNumbers(){
        return new Random()
            .ints(1,10)
            .boxed()
            .limit(3)
            .map(m -> Integer.toString(m))
            .collect(Collectors.toList());
    }


}
