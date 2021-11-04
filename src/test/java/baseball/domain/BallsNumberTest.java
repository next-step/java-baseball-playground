package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BallsNumberTest {

    @Test
    void range() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumber(0);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumber(10);
        });

        new BallNumber(1);
        new BallNumber(9);
    }
}
