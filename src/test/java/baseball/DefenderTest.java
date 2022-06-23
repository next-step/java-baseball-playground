package baseball;

import static org.assertj.core.api.Assertions.assertThat;

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
}
