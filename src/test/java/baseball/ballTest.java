package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ballTest {

    private Ball input_com;

    @BeforeEach
    void setUp() {
        input_com = new Ball(1, 4);
    }

    @Test
    void strike() {
        Assertions.assertEquals(input_com.play(new Ball(1, 4)), BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Assertions.assertEquals(input_com.play(new Ball(2, 4)), BallStatus.BALL);
    }

    @Test
    void nothing() {
        Assertions.assertEquals(input_com.play(new Ball(3, 6)), BallStatus.NOTHING);
    }

    @Test
    void error() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> input_com.play(new Ball(3, 10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 9 사이의 숫자를 입력하세요.");
    }
}
