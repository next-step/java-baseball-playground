package study;

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

    // Test Case 구현
    @Test
    @DisplayName("사이즈 크기 구현")
    public void sizeCheck() throws Exception {
        //given

        //when
        int size = numbers.size();
        //then
        assertThat(size).isEqualTo(3);

    }
    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    void usingContains(int a) throws Exception {
        assertTrue(numbers.contains(a));
        System.out.println(a);

    }

    @DisplayName("CsvSource를 활용")
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    @ParameterizedTest
    void usingCsvSource_true_false(int element,boolean expected){
        assertThat(numbers.contains(element)).isEqualTo(expected);

        assertEquals(numbers.contains(element),expected);
    }



}