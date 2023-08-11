package baseball;

import baseball.domain.GameNumber;
import baseball.domain.Judgement;
import baseball.domain.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Judgement judgement = new Judgement();
        NumberGenerator numberGenerator = new NumberGenerator();
        List<GameNumber> comNumbers = numberGenerator.createGameNumbers(Arrays.asList(1, 2, 3));
        List<GameNumber> userNumbers = numberGenerator.createGameNumbers(Arrays.asList(2, 1, 7));

        System.out.println(judgement.correctCount(comNumbers, userNumbers));
    }
}
