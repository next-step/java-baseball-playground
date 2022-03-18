package PlusCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersParserTest {
    @Test
    void null_또는_빈문자_테스트() {
        assertThat(NumbersParser.parse("")).contains("0");
        assertThat((NumbersParser.parse(null))).contains("0");
    }

    @Test
    void 숫자_하나를_입력받은_경우_테스트() {
        assertThat(NumbersParser.parse("1")).contains("1");
    }

    @Test
    void 쉼표_구분자로_숫자들을_입력받은_경우_테스트() {
        assertThat(NumbersParser.parse("1,2")).containsExactly("1", "2");
        assertThat(NumbersParser.parse("1,2,3")).containsExactly("1", "2", "3");
    }

    @Test
    void 쉼표_또는_콤마를_구분자로_숫자들을_입력받은_경우_테스트() {
        assertThat(NumbersParser.parse("1,2")).containsExactly("1", "2");
        assertThat(NumbersParser.parse("1:2")).containsExactly("1", "2");
        assertThat(NumbersParser.parse("1,2:3,4:5")).containsExactly("1", "2", "3", "4", "5");
    }

    @Test
    void 커스터마이징한_구분자로_숫자들을_입력받은_경우_테스트() {
        assertThat(NumbersParser.parse("//;\n1;2;3")).containsExactly("1", "2", "3");
    }

    @Test
    void 음수를_입력한_경우_예외처리_테스트() {
        assertThatThrownBy(() -> {
            NumbersParser.parse("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }
}
