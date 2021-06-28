package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SystemOperatorTest {

    @Test
    void test() {
        // Given
        ResultDTO resultDTO = new ResultDTO(0, 3);

        // When
        boolean isCorrect = SystemOperator.isCorrect(resultDTO);

        // Then
        Assertions.assertTrue(isCorrect);
    }

    @Test
    void testWithFalse() {
        // Given
        ResultDTO resultDTO = new ResultDTO(2, 0);

        // When
        boolean isCorrect = SystemOperator.isCorrect(resultDTO);

        // Then
        Assertions.assertFalse(isCorrect);
    }
}
