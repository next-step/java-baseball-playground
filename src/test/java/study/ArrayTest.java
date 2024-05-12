package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ArrayTest {
    private List<String> list = Arrays.asList("1", "2", "3");

    @Test
    void contains(){
        assertThat(list).contains("1");
    }

    @Test
    void isNotEmpty(){
        assertThat(list).isNotEmpty();
    }

    @Test
    void startsWith(){
        assertThat(list).startsWith("1");
    }

    @Test
    void complexTest(){
        assertThat(list)
        .isNotEmpty()
        .contains("1")
        .doesNotContainNull() // null을 포함하고 있지 않고
        .containsSequence("2", "3"); 
        // "2", "3" 순서대로 요소를 포함하고 있는 부분이 있는지 확인
    }


    
}
