package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    @DisplayName("3 Strike")
    @ParameterizedTest
    @CsvSource(value = {"123:123", "987:987"}, delimiter = ':')
    void true_3Strike(String me, String you) {
        assertThat(BaseballGame.isStrike(me,you)).isEqualTo(3);
    }

    // num => "num스트라이크" 는 view에서 진행
    @DisplayName("1 Strike")
    @ParameterizedTest
    @CsvSource(value = {"123:156", "987:127"}, delimiter = ':')
    void true_1Strike(String me, String you){
        assertThat(BaseballGame.isStrike(me,you)).isEqualTo(1);
    }

    @DisplayName("1 Ball")
    @ParameterizedTest
    @CsvSource(value = {"145:713", "671:213"}, delimiter = ':')
    void true_1Ball(String me, String you){
        assertThat(BaseballGame.isBall(me,you)).isEqualTo(1);
    }

    @DisplayName("2 Ball")
    @ParameterizedTest
    @CsvSource(value = {"471:713", "341:213"}, delimiter = ':')
    void true_2Ball(String me, String you){
        assertThat(BaseballGame.isBall(me,you)).isEqualTo(2);
    }
}
