package study.stringCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    Number first;
    Number second;
    Number result;

    @BeforeEach
    void init() {
        first = Number.from("6");
        second = Number.from("2");
    }

    @Test
    void plus() {
        Number result = Number.from("8");

        Number actualNumber = first.plus(second);

        Assertions.assertThat(actualNumber).isEqualTo(result);
    }

    @Test
    void minus() {
        Number result = Number.from("4");

        Number actualNumber = first.minus(second);

        Assertions.assertThat(actualNumber).isEqualTo(result);
    }

    @Test
    void multiply() {
        Number result = Number.from("12");

        Number actualNumber = first.multiply(second);

        Assertions.assertThat(actualNumber).isEqualTo(result);
    }

    @Test
    void dividedBy() {
        Number result = Number.from("3");

        Number actualNumber = first.dividedBy(second);

        Assertions.assertThat(actualNumber).isEqualTo(result);
    }
}