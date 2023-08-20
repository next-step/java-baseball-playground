package study.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import utils.baseball.BullsAndCows;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BullsAndCowsTest {
    private BullsAndCows game = BullsAndCows.makeNewGame();

    @BeforeEach
    void givenComputerNumbers() {
        //given
        game.setComputerNumbers(new int[] {1, 2, 3});
    }

    @ParameterizedTest
    @MethodSource("countArgs")
    void countStrikeAndBallTest(String inputValue, int strikeCount, int ballCount) {
        //when
        game.progressGameRound(inputValue);
        //then
        assertAll("countTest",
                () -> assertThat(game.getStrikeCount()).isEqualTo(strikeCount),
                () -> assertThat(game.getBallCount()).isEqualTo(ballCount)
        );
    }

    static Stream<Arguments> countArgs() {
        return Stream.of(
                Arguments.arguments("987", 0, 0),
                Arguments.arguments("198", 1, 0),
                Arguments.arguments("128", 2, 0),
                Arguments.arguments("123", 3, 0),
                Arguments.arguments("981", 0, 1),
                Arguments.arguments("912", 0, 2),
                Arguments.arguments("312", 0, 3),
                Arguments.arguments("913", 1, 1),
                Arguments.arguments("321", 1, 2)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"987:true", "654:true ",
                        "123:false", "193:false", "929:false",
                        "321:false", "298:false"},
                delimiter = ':')
    void isNothingTest(String inputValue, boolean expected) {
        //when
        game.progressGameRound(inputValue);
        //then
        assertThat(game.isNothing()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true",
            "987:false", "654:false ",
            "193:false", "728:false", "321:false", "298:false"},
            delimiter = ':')
    void isAllStrike(String inputValue, boolean expected) {
        //when
        game.progressGameRound(inputValue);
        //then
        assertThat(game.isAllStrike()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"},
            delimiter = ':')
    void shouldReplayGame(String inputOption, boolean expected) {
        //when
        boolean replay = game.shouldReplayGame(inputOption);
        //then
        assertThat(replay).isEqualTo(expected);
    }
}
