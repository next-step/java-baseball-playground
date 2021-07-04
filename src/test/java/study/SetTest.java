package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

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
    //Set은 중복값 허용 안한다.
    @DisplayName("set 크기 확인")
    @Test
    void checkSize_OK() {
        System.out.println(numbers.toString());
        int actual = numbers.size();
        assertThat(actual).isEqualTo(3);
    }

}
