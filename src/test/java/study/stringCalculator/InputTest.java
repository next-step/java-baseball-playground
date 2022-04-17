package study.stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    private final Input input = new Input();

    @BeforeEach
    void init() {
        input.init();
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("null값으로 업데이트를 하면 에러가 발생한다.")
    void test(String givenString) {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> input.update(givenString));
    }

    @Test
    @DisplayName("공백값으로 업데이트를 하면 에러가 발생한다.")
    void test2() {
        String givenString = " ";

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> input.update(givenString));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("길이 0인 문자열로 업데이트를 하면 에러가 발생한다.")
    void test3(String givenString) {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> input.update(givenString));
    }
}