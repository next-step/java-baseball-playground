package study;

import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.FieldValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    StringCalculator calculator;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void test() {
        systemIn("2 + 3 * 4 / 2");
        assertThat(calculator.executeCalculator()).isEqualTo(10);
    }
}
