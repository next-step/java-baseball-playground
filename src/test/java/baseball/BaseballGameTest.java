package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("숫자 입력 받기")
    void getInputName() {
        // given
        setInputStream(number);

        // when
        final String inputNumber = game.getInputNumber(new Scanner(System.in));

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

    @ParameterizedTest
    @CsvSource({"0, 0, 낫싱", "1, 0, 1볼", "1, 2, 1볼 2스트라이크", "0, 3, 3스트라이크"})
    @DisplayName("비교 결과 생성")
    void createCompareResult(final int ball, final int strike, final String expected) {
        // given
        // when
        final String result = game.createCompareResult(ball, strike);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1, true", "2, false"})
    @DisplayName("종료 여부 선택")
    void isEnd(int inputNumber, boolean expected) {
        // given
        setInputStream(inputNumber + "\n");

        // when
        final boolean isEnd = game.isEnd(new Scanner(System.in));

        // then
        assertThat(isEnd).isEqualTo(expected);
    }

    private void setInputStream(String number) {
        InputStream in = new ByteArrayInputStream(number.getBytes());
        System.setIn(in);
    }
}