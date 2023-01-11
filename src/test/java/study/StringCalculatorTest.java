package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StringCalculatorTest {

    StringCalculator stringCalculator;
//    StringFormulaValidator stringSentenceValidator;

    @BeforeAll
    void setup() {
//        this.stringSentenceValidator = new StringFormulaValidator();
//        this.stringCalculator = new StringCalculator(stringSentenceValidator);
        this.stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("2 + 3 * 4 / 2 를 입력받으면 10을 반환한다.")
    void prints_out_10() {
        String value = "2 + 3 * 4 / 2";

        String result = stringCalculator.calculate(value);

        assertThat(result).isEqualTo("10");
    }

    @ParameterizedTest
    @CsvSource(value = {
        "2 + 3 * 4 / 2:10",
        "3 + 1 * 3 / 5:2",
        "1 + 2 + 3 + 4 + 1 / 100:0",
        "3 * 2 / 5 + 3 / 3:1"
    },
        delimiter = ':'
    )
    void 계산이_가능한_수식을_입력하면_그에_맞는_정답을_반환한다(String sentence, String expectedResult) {
        String result = stringCalculator.calculate(sentence);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "2 + 3 * 4 / 2 *",
        "+ 3 + 1 * 3 / 5",
        "3 * 4 + 3 +* 3",
        "1 + 2 + 3 /+ 4 + 100 / 200",
        "4 3 + 2",
    })
    void 계산_할_수_없는_수식을_입력하면_예외를_반환한다(String sentence) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.calculate(sentence);
        });
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }

}