package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomNumberGeneratorTest {
    @Test
    void test() {
        // Given

        // When
        List result = RandomNumberGenerator.generate();

        // Then
        Assertions.assertThat(((Object)result).getClass().isInstance(List.class));
    }
}
