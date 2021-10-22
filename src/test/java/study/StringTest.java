package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("String replace 메서드 활용")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    
    @Test
    @DisplayName("String split 메서드 활용")
    void test1() {
        String[] split1 = ("1,2").split(",");
        String[] split2 = ("1").split(",");

        System.out.println("split1: " + Arrays.toString(split1));
        System.out.println("split1: " + Arrays.toString(split2));

        assertThat(split1).contains("1","2");
        assertThat(split2).containsExactly("1");
    }

    @Test
    @DisplayName("String substring 메서드 활용")
    void test2() {
        String preString = "(1,2)";
        String result = preString.substring(1, preString.length() - 1);

        System.out.println("result: " + result.toString());

        assertThat(result).isEqualTo("1,2");
    }

    // Throwable Assertions 활용
    // 예외 메시지, 스택 추적 검사, 예외가 이미 throw 되었는지 확인
    @Test
    @DisplayName("assertThatThrownBy() : Java 8 exception assertion 표준 스타일")
    void test3() {
        String name = "abc";
        int index = 10;

        assertThatThrownBy(() -> {
            char result = name.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

    @Test
    @DisplayName("assertThatExceptionOfType() : 예외 클래스 넣기")
    void test4() {
        String name = "abc";
        int index = 10;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    name.charAt(index);
                }).withMessageContaining("%d", index);
    }
}

