package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationCheckTest {


    @DisplayName("입력된 숫자가 3인지 판별하기")
    @Test
    void 입력된숫자가3인가(){
        assertThat(ValidationCheck.isThreeWord("123")).isTrue();
        assertThat(ValidationCheck.isThreeWord("12")).isFalse();
    }


    @DisplayName("입력된 숫자가 1~9까지의 숫자인지 판별하기")
    @Test
    void 입력된숫자_1_9(){
        assertThat(ValidationCheck.isCorrect(1)).isTrue();
        assertThat(ValidationCheck.isCorrect(9)).isTrue();
        assertThat(ValidationCheck.isCorrect(0)).isFalse();
        assertThat(ValidationCheck.isCorrect(10)).isFalse();
    }


}
