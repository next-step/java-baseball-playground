package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class ValidatorTest {

    @Test
    void test() {
        // Given
        List<Integer> list = Arrays.asList(1, 2, 3);

        // When
        boolean result = Validator.checkSize(list);

        // Then
        Assertions.assertTrue(result);
    }

    @Test
    void testWithDuplicate() {
        // Given
        List<Integer> list = Arrays.asList(1, 3);

        // When
        boolean result = Validator.isUnique(1, list);

        // Then
        Assertions.assertFalse(result);
    }

    @Test
    void testWithDuplicate2() {
        // Given
        List<Integer> list = Arrays.asList(2, 3);

        // When
        boolean result = Validator.isUnique(1, list);

        // Then
        Assertions.assertTrue(result);
    }
}
