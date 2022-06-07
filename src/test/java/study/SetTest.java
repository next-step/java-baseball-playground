package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("set의 사이즈를 확인한다.")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("set에 1,2,3이 존재하는지 확인한다.(1)")
    void contains1() {
        assertThat(numbers).contains(1,2,3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("set에 1,2,3이 존재하는지 확인한다.(2)")
    void contains2(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("1,2,3을 넣으면 참,4,5를 테스트하면 거짓을 반환한다.")
    void contains3(int number, boolean isTrue) {
        assertThat(numbers.contains(number)).isEqualTo(isTrue);
    }
}
