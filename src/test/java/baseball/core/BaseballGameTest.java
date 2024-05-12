package baseball.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    @DisplayName("1에서 9까지 서로 다른 임의의 수 3개를 생성한다.")
    @Test
    void generateRandomNumbers() {
        // given when
        final String randomNumbers = BaseballGame.generateRandomNumbers();

        // then
        final HashSet<String> set = new HashSet<>(Arrays.asList(randomNumbers.split("")));
        assertThat(set).hasSize(3);
    }

    @ParameterizedTest(name = "{0} 입력 시 {1}을 반환한다.")
    @CsvSource({
            "1, CONTINUE",
            "2, END"
    })
    void askForNewGameOrExit(final String input, final GameStatus expectedStatus) {
        // given
        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        final String correctAnswer = "123";
        final BaseballGame baseballGame = new BaseballGame(correctAnswer);

        // when
        final GameStatus actualStatus = baseballGame.askForNewGameOrExit();

        // then
        assertThat(actualStatus).isEqualTo(expectedStatus);
    }

}