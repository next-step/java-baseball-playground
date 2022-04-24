package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUP(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //Test Case 구현
    @Test
    @DisplayName("Set 사이즈 확인")
    void setSize(){
        System.out.println(numbers.size());
    }

    @Test
    void contains(){
        Assertions.assertThat(numbers.contains(1)).isTrue();
        Assertions.assertThat(numbers.contains(2)).isTrue();
        Assertions.assertThat(numbers.contains(3)).isTrue();
    }
}

