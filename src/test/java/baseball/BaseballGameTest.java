package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    BaseballGame game;

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
}