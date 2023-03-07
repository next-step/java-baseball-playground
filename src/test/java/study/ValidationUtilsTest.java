package study;

import baseball.util.ValidationUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationUtilsTest {

    @Test
    void checkNumber(){
        assertThat(ValidationUtils.isNumber("2")).isTrue();
        assertThat(ValidationUtils.isNumber("s")).isFalse();
        assertThat(ValidationUtils.isNumber("223424")).isTrue();
        assertThat(ValidationUtils.isNumber("1w2")).isFalse();
        assertThat(ValidationUtils.isNumber("s1s")).isFalse();
    }

    @Test
    void checkDigits(){
        assertThat(ValidationUtils.macthLength("123",3)).isTrue();
        assertThat(ValidationUtils.macthLength("123s",3)).isFalse();
        assertThat(ValidationUtils.macthLength("1",0)).isFalse();
    }

    @Test
    void distinctNumber(){

        assertThat(ValidationUtils.isDuplicationNumber(Arrays.asList(1, 1, 1))).isFalse();
        assertThat(ValidationUtils.isDuplicationNumber(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(ValidationUtils.isDuplicationNumber(Arrays.asList(1, 3))).isTrue();
        assertThat(ValidationUtils.isDuplicationNumber(Arrays.asList(1, 1))).isFalse();
        assertThat(ValidationUtils.isDuplicationNumber(Arrays.asList(1))).isTrue();
        assertThat(ValidationUtils.isDuplicationNumber(Arrays.asList())).isTrue();
    }


}
