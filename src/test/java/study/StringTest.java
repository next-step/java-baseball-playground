package study;


import java.util.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
//        String actual = "abc".replace("b", "d");
//        assertThat(actual).isEqualTo("adc");

        // 요구사항 1번, split한 값이 의도한대로 나뉘어졌는지 테스트 코드 작성
//        String[] values = "1,2".split(",");
//        assertThat(values).contains("1","2");
//        assertThat(values).containsExactly("1","2");

        // 요구사항 2번, String Method 중 substring을 이용 하여 슬라이싱
//        String values = "(1,2)";
//        System.out.println(values.substring(1, 4));

        // 요구사항 3번
        String values = "abc";
        // 3-1 charAt을 활용 하여 인덱스에 위치한 값 출력하기
//        char value1 = values.charAt(0);
//        char value2 = values.charAt(1);
//        char value3 = values.charAt(2);
//
//        System.out.print(value1);
//        System.out.print(value2);
//        System.out.print(value3+"\n");

        // 3-2 out of index 에러 테스트 하기
//        System.out.println(values.get(3));
//        assertThatThrownBy(()-> {
//            values.charAt(3);}).isInstanceOf(IndexOutOfBoundsException.class);

        // 3-3 @DisplayName method 의견 나타내기
        // 3-3.1
//        assertThatThrownBy(() -> {
//            ArrayList<String> list = new ArrayList<>(Arrays.asList("String one", "String two"));
//            list.get(2);
//        }).isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("Index 2 out of bounds for length 2");

        // 3-3.2
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    ArrayList<String> list = new ArrayList<>(Arrays.asList("String one", "String two"));
                    list.get(2);
                }).withMessageMatching("Index 2 out of bounds for length 2");

    }
}

