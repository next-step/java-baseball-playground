package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsGeneratorTest {

    @DisplayName("Can be System Balls")
    @Test
    void are_BallsGenerated () {
        List<Ball> ballList = Arrays.asList(new Ball(new BallNum("1"), 1),
                                            new Ball(new BallNum("3"), 2),
                                            new Ball(new BallNum("7"), 3));
        assertThat(new BallsGenerator(ballList)).isEqualTo(BallsGenerator.class);
    }
}
