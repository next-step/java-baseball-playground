package baseball;

import java.util.List;

@FunctionalInterface
public interface RandomNumberGenerator {
    public List<Integer> generate();
}
