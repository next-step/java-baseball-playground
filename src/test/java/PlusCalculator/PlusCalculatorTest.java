package PlusCalculator;

import com.sun.org.apache.xpath.internal.operations.Plus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlusCalculatorTest {
    @Test
    void null_또는_빈문자_테스트() {
        assertThat(PlusCalculator.calculate("")).isEqualTo(0);
        assertThat((PlusCalculator.calculate(null))).isEqualTo(0);
    }

    @Test
    void 숫자_하나를_입력받은_경우_테스트() {
        assertThat(PlusCalculator.calculate("1")).isEqualTo(1);
    }

    @Test
    void 쉼표_구분자로_숫자들을_입력받은_경우_테스트() {
        assertThat(PlusCalculator.calculate("1,2")).isEqualTo(3);
        assertThat(PlusCalculator.calculate("1,2,3")).isEqualTo(6);
    }

    @Test
    void 쉼표_또는_콤마를_구분자로_숫자들을_입력받은_경우_테스트() {
        assertThat(PlusCalculator.calculate("1,2")).isEqualTo(3);
        assertThat(PlusCalculator.calculate("1:2")).isEqualTo(3);
        assertThat(PlusCalculator.calculate("1,2:3,4:5")).isEqualTo(15);
    }

    @Test
    void 커스터마이징한_구분자로_숫자들을_입력받은_경우_테스트() {
        assertThat(PlusCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수를_입력한_경우_예외처리_테스트() {
        assertThatThrownBy(() -> {
            PlusCalculator.calculate("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }
}
