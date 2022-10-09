import baseballgame.domain.Ball;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
public class BallValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0,10})
    void 볼_숫자_범위_검증_테스트(int input){
        assertThatThrownBy(()->{
            Ball ball = new Ball(1,input);
        }).isInstanceOf(RuntimeException.class);
    }
}
