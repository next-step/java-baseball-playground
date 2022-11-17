import org.junit.jupiter.api.BeforeEach;
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


}