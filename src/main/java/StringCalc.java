import baseball2.domain.Judgment;
import baseball2.domain.NumberGenerator;
import baseball2.domain.Referee;

import java.util.Arrays;
import java.util.List;

public class StringCalc {

    public static void main(String[] args) {
        Referee referee = new Referee();
        String result = referee.compare(Arrays.asList(7, 8, 9), Arrays.asList(1, 2, 3));
        System.out.println(result);
    }
}
