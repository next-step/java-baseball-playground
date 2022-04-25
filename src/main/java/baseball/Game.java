package baseball;

import java.util.List;

public class Game {

    public static void main(String[] args) {

        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> com = numberGenerator.randomNumberGenerator();
    }
}
