package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항1")
    void request1(){
        /*
         - "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
         - "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

         - 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
         - 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
         **/

        String numbers = "1,2";
        String number = "1";

        String[] splittedNums = new String[2];
        splittedNums = numbers.split(",");

        assertThat(splittedNums).contains("1", "2");

        splittedNums = number.split(",");
        assertThat(splittedNums).containsExactly("1");
    }


    @Test
    @DisplayName("요구사항2")
    void request2(){
        /*
        - "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
         **/
        String nums = "(1,2)";
        int delIndex1 = nums.indexOf("(") +1; //index가 0이므로 +1 인덱스값부터 필요한 문자열
        int delIndex2 = nums.indexOf(")");

        String finNum = nums.substring(delIndex1,delIndex2);

        assertThat(finNum).isEqualTo("1,2");
    }


    @Test
    @DisplayName("요구사항3")
    void request3(){
        /*
          - "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
          - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
          - JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
        */

        String abc = "abc";

        char indexChar = abc.charAt(2);
        int index = abc.indexOf(indexChar);
        int size = abc.length();

        assertThat(indexChar+"").isEqualTo(abc.charAt(index)+"");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {

                    char indChar = abc.charAt(4);
                    assertThat(indChar+"").isEqualTo(abc.charAt(index)+"");

                }).withMessageMatching("String index out of range: 4");

    }
}
