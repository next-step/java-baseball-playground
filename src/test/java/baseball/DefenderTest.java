package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;

import baseball.Defender.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DefenderTest {

    static class FakeRandomUtil implements RandomUtil {

        String numbers;
        int currentIndex;

        FakeRandomUtil(String samples) {
            numbers = samples;
            currentIndex = 0;
        }

        @Override
        public int generateRandomGameDigit() {
            int picked = Integer.parseInt(String.valueOf(numbers.charAt(currentIndex)));
            currentIndex = (currentIndex + 1) % numbers.length();

            return picked;
        }

    }

    private Defender makeDefenderWithFakeRandomUtil(String sample) {
        FakeRandomUtil fakeRandom = new FakeRandomUtil(sample);
        return new Defender(fakeRandom);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "1123"})
    @DisplayName("수비가 1-9에서 서로 다른 3자리 수를 만드는지 확인한다")
    void generateNotDuplicatedThreeNumbers(String sample) {
        Defender defender = makeDefenderWithFakeRandomUtil(sample);

        defender.prepareGameDigits();

        assertThat(defender.getGameDigitsAt(0)).isNotEqualTo(defender.getGameDigitsAt(1));
        assertThat(defender.getGameDigitsAt(0)).isNotEqualTo(defender.getGameDigitsAt(2));
        assertThat(defender.getGameDigitsAt(1)).isNotEqualTo(defender.getGameDigitsAt(2));
    }

    private Defender makeDefenderWithSampleGameDigits(String sample) {
        Defender defender = makeDefenderWithFakeRandomUtil(sample);
        defender.prepareGameDigits();

        return defender;
    }

    @ParameterizedTest
    @CsvSource(value = {"145:1", "425:1", "453:1", "124:2", "143:2", "123:3"}, delimiter = ':')
    @DisplayName("주어진 123과 평가해서 스트라이크 개수를 확인한다")
    void evaluateStrikeCount(String input, int expected) {
        Defender defender = makeDefenderWithSampleGameDigits("123");

        defender.evaluate(input);

        int actual = defender.getStrikeCount();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"415:1", "451:1", "245:1", "412:2", "312:3"}, delimiter = ':')
    @DisplayName("주어진 123과 평가해서 볼 개수를 확인한다")
    void evaluateBallCount(String input, int expected) {
        Defender defender = makeDefenderWithSampleGameDigits("123");

        defender.evaluate(input);

        int actual = defender.getBallCount();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true", "132:false", "213:false", "321:false"}, delimiter = ':')
    @DisplayName("주어진 123과 평가해서 3스트라이크인지 확인한다")
    void evaluateTripleStrike(String input, Boolean expected) {
        Defender defender = makeDefenderWithSampleGameDigits("123");

        defender.evaluate(input);

        Boolean actual = defender.isTripleStrike();

        assertThat(actual).isEqualTo(expected);
    }
}
