import baseball.Balls;
import baseball.Prompt;
import utils.RandomGenerator;

import java.io.IOException;
import java.util.List;

public class BaseballApplication {
    public static void main(String[] args) throws IOException {
        int command = 1;
        Prompt prompt = new Prompt();
        while (command == 1) {
            RandomGenerator generator = new RandomGenerator();
            List<Integer> randomNumbers = generator.createRandomNumbers();
            Balls answer = new Balls(randomNumbers);
            randomNumbers.forEach(System.out::print);
            System.out.println();
            prompt.printResult(answer);
            command = prompt.askAgain();
        }
    }
}
