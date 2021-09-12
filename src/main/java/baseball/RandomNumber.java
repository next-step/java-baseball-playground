package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumber {
    private List<Integer> value;

    public RandomNumber() {
        HashSet<Integer> hashSet = new HashSet<>();
        while(hashSet.size() < 3){
            hashSet.add((int) (Math.random() * 9 + 1));
        }
        this.value = new ArrayList<>(hashSet);
    }

    public List<Integer> getValue() {
        return value;
    }
}
