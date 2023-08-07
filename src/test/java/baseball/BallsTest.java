package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    @Test
    void strikesTest() {
        Balls balls = new Balls("1", "2", "3");
        Balls ansBalls = new Balls("1", "2", "3");

        BallCalculator calculator = new BallCalculator();
        int[] result = calculator.calculate(balls, ansBalls);

        assertThat(result).containsExactly(3, 0);
    }

    @Test
    void ballsTest() {
        Balls balls = new Balls("3", "1", "2");
        Balls ansBalls = new Balls("1", "2", "3");

        BallCalculator calculator = new BallCalculator();
        int[] result = calculator.calculate(balls, ansBalls);

        assertThat(result).containsExactly(0, 3);
    }

    @Test
    void nothingTest() {
        Balls balls = new Balls("4", "5", "6");
        Balls ansBalls = new Balls("1", "2", "3");

        BallCalculator calculator = new BallCalculator();
        int[] result = calculator.calculate(balls, ansBalls);

        assertThat(result).containsExactly(0, 0);
    }
}
