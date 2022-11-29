package baseball;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class BaseballTest {

    @Test
    void 야구_숫자_1_9_검증(){
        boolean result = ValidationUtils.validNo(9);
        assertThat(result).isTrue();

    }
}
