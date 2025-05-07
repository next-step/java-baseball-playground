package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

    @Test
    void 야구_숫자_1_9_검증() {

        Assertions.assertTrue(ValidationUtils.ValidNo(9));
        Assertions.assertTrue(ValidationUtils.ValidNo(1));
        Assertions.assertFalse(ValidationUtils.ValidNo(0));
        Assertions.assertFalse(ValidationUtils.ValidNo(10));
    }
}