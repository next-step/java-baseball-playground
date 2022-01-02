package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballTest {

    Baseball baseball = new Baseball();

    @DisplayName("중복 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:1:false", "1:2:true"}, delimiter = ':')
    void doubleCheckTest(int createNumber, int checkNumber, boolean expected) {
        assertThat(baseball.doubleCheck(createNumber, checkNumber)).isEqualTo(expected);
    }
}
