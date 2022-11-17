import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * 기능 정리 :
 *  1. nextLine()을 사용해 공백을 포함하여 입력받는다.
 *  2. split()을 사용해 공백을 기준으로 문자열들을 분리한다.
 *  3. 분리된 String 문자열들을 Integer.parseInt()을 사용해 형변환 해준다.
 *  4. 들어온 문자를 순서대로 계산해준다.
 *  5. 공백인지 아닌지 검사.
 *  6. 결과 반환.
 */

class StringCalculatorTest {
    StringCalculator cal;

    @BeforeEach
    public void setCal() {
        cal = new StringCalculator();
    }

    @Test
    public void splitSpace() {
        String[] res = cal.split("2 + 3 * 4 / 2");

        assertThat(res).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    public void toIntTest() {
        int res = cal.toInt("1");

        assertThat(res).isEqualTo(1);
    }

    @Test
    public void calculateTest() {

        int res1 = cal.calculate(1, '+', 2);
        assertThat(res1).isEqualTo(3);

        int res2 = cal.calculate(3, '*', 2);
        assertThat(res2).isEqualTo(6);
    }

    @Test
    @DisplayName("잘못된 문자를 입력했을때 발생하는 예외 테스트")
    void sequnceAtException() {

        assertThatThrownBy(() -> cal.calculate(3, '&', 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}