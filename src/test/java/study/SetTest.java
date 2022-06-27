package study;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 객체 Size")
    void setSizeTest() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("Set 객체 contains 중복 코드 제거 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void usingContainsRemoveDuplicateCode(int nums) {
        assertTrue(numbers.contains(nums));
    }

    @DisplayName("CsvSource사용")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void usingContainsTestForTrueFalse(int num, boolean bool) {
        assertThat(numbers.contains(num)).isEqualTo(bool);

        assertEquals(numbers.contains(num), bool);
    }
}
