package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    void add1() {
        //given //when
        int result1 = stringCalculator.add("");
        int result2 = stringCalculator.add(null);

        //then
        assertThat(result1).isZero();
        assertThat(result2).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void add2() {
        //given //when
        int result = stringCalculator.add("1");

        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @Test
    void add3() {
        //given //when
        int result = stringCalculator.add("1,3");

        //then
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @Test
    void add4() {
        //given //when
        int result = stringCalculator.add("1,2:3");

        //then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("지정 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    void add5() {
        //given //when
        int result = stringCalculator.add("//;\n1;2;3");

        //then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    void add6() {
        //given //when //then
        assertThatThrownBy(() -> stringCalculator.add("1,-2"))
                .isInstanceOf(RuntimeException.class);
    }
}