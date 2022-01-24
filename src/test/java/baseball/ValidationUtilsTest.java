package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    void BaseballCheckNum() {
        assertThat(ValidationUtils.validNO(9)).isTrue();
    }
}
