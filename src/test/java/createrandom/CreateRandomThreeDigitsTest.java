package createrandom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateRandomThreeDigitsTest {

    @Test
    @DisplayName("중복된 숫자 확인")
    void 중복된_숫자확인() {
        CreateRandomThreeDigits createRandomThreeDigits = new CreateRandomThreeDigits();
        assertThat(createRandomThreeDigits.checkDuplicate(Arrays.asList(1, 2, 3))).isTrue();
    }

    @Test
    @DisplayName("3자리인지 확인")
    void 세자리_확인() {
        CreateRandomThreeDigits createRandomThreeDigits = new CreateRandomThreeDigits();
        assertThat(createRandomThreeDigits.checkThreeDigits(Arrays.asList(1, 2, 3))).isTrue();
    }
}
