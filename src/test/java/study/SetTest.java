package study;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void sizeTest(){
        int actual = numbers.size();
        assertThat(actual).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int i){
        assertThat(numbers.contains(i)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value={"1:true", "2:true", "3:true", "4: false", "5:false"}, delimiter = ':')
    void containsFailureTest(int i, boolean result){
        assertThat(numbers.contains(i)).isEqualTo(result);
    }
}
