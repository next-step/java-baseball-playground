package stringCalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static stringCalculator.StringCalc.calculate;


public class StringCalcTest {


    //NullAndEmpty but still define the dataType
    @DisplayName("NullOrEmpty")
    @ParameterizedTest
    @ValueSource(strings = {" ","", "\n"})
    void isBlank_ShouldThrowException(String input) {
        assertThatThrownBy(() -> {
            calculate(input);}).isInstanceOf(IllegalArgumentException.class); }

    //why static
    @DisplayName("simple +")
    @Test
    void isSix() {
        assertThat(calculate("2 + 3 + 1")).isEqualTo(6);
    }

    @DisplayName("simple *")
    @Test
    void isTwelve() {
        assertThat(calculate("2 * 3 * 2")).isEqualTo(12);
    }

    @DisplayName("Correct")
    @Test
    void isTen() {
//        StringCalc stringCalc = new StringCalc();
        assertThat(calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
