package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseballGameFactory {

    public static List<Integer> createNumbers() {
        List<Integer> baseballs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(baseballs);
        List<Integer> you = baseballs.subList(0, 3);
        System.out.println(you.toString());
        return you;
    }
}
