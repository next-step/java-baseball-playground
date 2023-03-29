package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {
    private Ball com;
    @BeforeEach
    void sutup(){
        com = new Ball(1, 4);
    }
    @Test
    void noting(){
        assertThat(com.play(new Ball(2,5))).isEqualTo(BallStatus.NOTING);
    }
    @Test
    void ball(){
        assertThat(com.play(new Ball(2,4))).isEqualTo(BallStatus.BALL);
    }
    @Test
    void strike(){
        assertThat(com.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
    }
}
