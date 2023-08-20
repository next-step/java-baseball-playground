package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.baseball.BullsAndCows;
import utils.baseball.PlayerInput;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BullsAndCowsTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "abc",
                            "1", "12",
                            "-1", "-999"})
    @DisplayName("입력값_3개의_숫자_아니면_예외_발생")
    void fail_validate_InputValue (String inputValue) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PlayerInput.validateInputNumber(inputValue);
                }).withMessageMatching("올바른 입력값이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "0", "123", "abc", "-1"})
    @DisplayName("게임_옵션_입력은_1,2이_아니면_예외_발생")
    void fail_validate_InputOption (String inputOption) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PlayerInput.validateInputGameOption(inputOption);
                }).withMessageMatching("올바른 입력값이 아닙니다.");
    }

    @ParameterizedTest
    @MethodSource("args")
    void countTest(String inputValue, int strikeCount, int ballCount) {
        //given
        BullsAndCows game = BullsAndCows.makeNewGame();
        game.setComputerNumbers(new int[] {1, 2, 3});
        //when
        game.progressGameRound(inputValue);
        //then
        assertAll("countTest",
                () -> assertThat(game.getStrikeCount()).isEqualTo(strikeCount),
                () -> assertThat(game.getBallCount()).isEqualTo(ballCount)
        );
    }

    static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments("987", 0, 0),
                Arguments.arguments("198", 1, 0),
                Arguments.arguments("128", 2, 0),
                Arguments.arguments("123", 3, 0),
                Arguments.arguments("901", 0, 1),
                Arguments.arguments("912", 0, 2),
                Arguments.arguments("312", 0, 3),
                Arguments.arguments("013", 1, 1),
                Arguments.arguments("321", 1, 2)
        );
    }


    @ParameterizedTest
    @CsvSource(value = {"987:true", "654:true ", "000:true",
                        "123:false", "103:false", "020:false",
                        "321:false", "298:false"},
                delimiter = ':')
    void isNothing(String inputValue, boolean expected) {
        //given
        BullsAndCows game = BullsAndCows.makeNewGame();
        game.setComputerNumbers(new int[] {1, 2, 3});
        //when
        game.progressGameRound(inputValue);
        //then
        assertThat(game.isNothing()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true",
            "987:false", "654:false ", "000:false",
            "103:false", "020:false", "321:false", "298:false"},
            delimiter = ':')
    void isAllStrike(String inputValue, boolean expected) {
        //given
        BullsAndCows game = BullsAndCows.makeNewGame();
        game.setComputerNumbers(new int[] {1, 2, 3});
        //when
        game.progressGameRound(inputValue);
        //then
        assertThat(game.isAllStrike()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"},
            delimiter = ':')
    void shouldReplayGame(String inputOption, boolean expected) {
        //given
        BullsAndCows game = BullsAndCows.makeNewGame();
        //when
        boolean replay = game.shouldReplayGame(inputOption);
        //then
        assertThat(replay).isEqualTo(expected);
    }
}
