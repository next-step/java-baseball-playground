package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class BallsTest {

    @Test
    void duplicate() {
        assertThatIllegalStateException().isThrownBy(() -> {
            new Balls(Arrays.asList(1, 1, 3));
        });

        new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void size() {
        assertThatIllegalStateException().isThrownBy(() -> {
            new Balls(Arrays.asList(1));
        });

        assertThatIllegalStateException().isThrownBy(() -> {
            new Balls(Arrays.asList(1, 2, 3, 4));
        });

        new Balls(Arrays.asList(1, 2, 3));
    }
}
