package baseball;

public class Game {

    public static void main(String[] args) {

        NumberGenerator numberGenerator = new NumberGenerator();
        Balls com = numberGenerator.randomNumberGenerator();
        Balls user = inputView.userInput();
    }
}
