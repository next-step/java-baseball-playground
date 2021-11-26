import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationUtilsTest {
    @Test
    @DisplayName("세 자리 숫자 검증")
    void validationTest() {
        boolean isThreeDigits = ValidationUtils.isValid(100);
        assertThat(isThreeDigits).isTrue();
    }

    @Test
    @DisplayName("세 자리 수중 중복이 있는지 검증")
    void duplicateTest(){
        boolean isDuplicated = ValidationUtils.isDuplicated(999);
        assertThat(isDuplicated).isTrue();
    }

    @Test
    @DisplayName(" 컴퓨터가 만들어 내는 세자리 수 확인")
    void comMadeNumTest(){
        Computer com = new Computer();
        assertEquals(315, com.getNumber());
    }
}
