package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @Test
    void strikeTest() {
        Ball ball = new Ball(0, "1");
        Balls ansBalls = new Balls("1", "2", "3");

        BallCalculator calculator = new BallCalculator();
        BallStatus status = calculator.calculate(ball, ansBalls);

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ballTest() {
        Ball ball = new Ball(0, "1");
        Balls ansBalls = new Balls("2", "1", "3");

        BallCalculator tester = new BallCalculator();
        BallStatus status = tester.calculate(ball, ansBalls);

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothingTest() {
        Ball ball = new Ball(0, "4");
        Balls ansBalls = new Balls("2", "1", "3");

        BallCalculator tester = new BallCalculator();
        BallStatus status = tester.calculate(ball, ansBalls);

        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
