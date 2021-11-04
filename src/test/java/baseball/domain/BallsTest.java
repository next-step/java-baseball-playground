package baseball.domain;

import baseball.exception.BallNumberSizeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BallsTest {

    @Test
    void duplicate() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Balls("113");
        });

        new Balls("123");
    }

    @Test
    void size() {
        assertThatExceptionOfType(BallNumberSizeException.class).isThrownBy(() -> {
            new Balls("1");
        });

        assertThatExceptionOfType(BallNumberSizeException.class).isThrownBy(() -> {
            new Balls("1234");
        });

        new Balls("123");
    }

    @Test
    void number() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Balls("asd");
        });
    }
}
