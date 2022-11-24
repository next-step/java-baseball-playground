package baseball;

import java.util.List;

@FunctionalInterface
public interface RandomListGenerator {
    public List<Integer> generate();
}
