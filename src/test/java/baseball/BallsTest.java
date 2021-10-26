package baseball;

import baseball.model.Ball;
import baseball.model.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {

    @Test
    @DisplayName("Balls가 올바르게 생성되는지 테스트")
    void makeBallsInstance(){
        int num = 0;
        Balls ballList = new Balls("123");
        for(Ball b : ballList.getBalls()){
            assertThat(b.equals(new Ball(num, num+1)));
            num++;
        }
    }

    @Test
    @DisplayName("숫자 list에 중복값과 숫자의 크기 여부를 테스트")
    void checkOverlap() {
        boolean s = Balls.validateNumbers("123");
        assertThat(s).isTrue();
    }

    @Test
    @DisplayName("중복값이 있을 경우 예외")
    void overlapExeption() {
        assertThatThrownBy(() -> {
            Balls.validateNumbers("121");
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("중복값이 발생했습니다.");
    }

    @Test
    @DisplayName("숫자가 범위를 넘어갈 경우 예외")
    void rangeExeption() {
        assertThatThrownBy(() -> {
            Balls.validateNumbers("120");
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("1~9 사이의 숫자가 아닙니다.");
    }
}
