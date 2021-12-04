package comparenumbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareNumbersTest {

    @Test
    @DisplayName("몇 개의 숫자가 같은 지 비교")
    void 몇개의_숫자가_같은지_확인(){
        CompareNumbers compareNumbers = new CompareNumbers();
        assertThat(compareNumbers.checkNumbers(Arrays.asList(3, 1, 2), Arrays.asList(1, 2, 3))).isEqualTo(3);
    }

    @Test
    @DisplayName("특정 자리에 특정 숫자가 몇 개 있는지 확인")
    void 특정자리_특정숫자갯수_확인(){
        CompareNumbers compareNumbers = new CompareNumbers();
        assertThat(compareNumbers.checkIndexNumber(Arrays.asList(3, 2, 4), Arrays.asList(1, 2, 3))).isEqualTo(1);
    }
}
