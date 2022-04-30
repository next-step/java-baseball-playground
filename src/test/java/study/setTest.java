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

public class setTest {
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
    @DisplayName("set의 사이즈 확인하는 테스트")
    void checkSetSize(){
        assertThat( numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("set의 구성요소 한번에 확인하기")
    @ValueSource(ints = {1,2,3})
    void contains(int no){
        // 소스배열에 담겨있는 것들을 하나씩 뽑아서
        assertThat(numbers.contains(no)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("1,2,3은 트루 4,5는 실패")
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    void containsCustom(String input,String expect){
        if(numbers.contains(input)){
           assertThat(numbers.contains(input)).isTrue();
        }
        assertThat(numbers.contains(input)).isFalse();
    }
}
