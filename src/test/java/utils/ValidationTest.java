package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {

    @Test
    void numberValidation(){
        assertThat(Validation.checkNumber(1)).isEqualTo(true);
        assertThat(Validation.checkNumber(9)).isEqualTo(true);
        assertThat(Validation.checkNumber(0)).isEqualTo(false);
        assertThat(Validation.checkNumber(10)).isEqualTo(false);
    }
}
