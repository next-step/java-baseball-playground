package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class BaseballGameTest {

    BaseballGame game;

    final String number = "713";

    @BeforeEach
    void setUp() {
        game = new BaseballGame();
    }

    @Test
    @DisplayName("서로 다른 수(1~9)로 이루어진 3자리의 수 생성")
    void createNumber() {
        // given
        // when
        final String number = game.createNumber();

        // then
        // 3자리 확인
        assertThat(number.length()).isEqualTo(3);

        Set<Character> set = new HashSet<>();
        for (char c : number.toCharArray()) {
            // 숫자 확인
            assertThat(Character.isDigit(c)).isTrue();
            // 1~9의 수 확인
            assertThat(c == '0').isFalse();
            set.add(c);
        }
        // 서로 다른 수 확인
        assertThat(set.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 입력 받기[실패] - 숫자가 아닌 문자")
    void getInputName_NotNumber() {
        // given
        setInputStream("14k");

        // when
        // then
        assertThatThrownBy(() -> game.getInputNumber())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("숫자를 입력해주세요");
    }

    @Test
    @DisplayName("숫자 입력 받기")
    void getInputName() {
        // given
        setInputStream(number);

        // when
        final String inputNumber = game.getInputNumber();

        // then
        assertThat(inputNumber).isEqualTo(number);
    }

    @ParameterizedTest
    @CsvSource({"713, 0", "123, 1", "671, 2", "137, 3"})
    @DisplayName("볼 개수 확인")
    void checkBall(final String inputNumber, final int expected) {
        // given
        // when
        final int ball = game.checkBall(number, inputNumber);

        // then
        assertThat(ball).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"137, 0", "789, 1", "213, 2", "713, 3"})
    @DisplayName("스트라이크 개수 확인")
    void checkStrike(final String inputNumber, final int expected) {
        // given
        // when
        final int strike = game.checkStrike(number, inputNumber);

        // then
        assertThat(strike).isEqualTo(expected);
    }

    private void setInputStream(String number) {
        InputStream in = new ByteArrayInputStream(number.getBytes());
        System.setIn(in);
    }
}