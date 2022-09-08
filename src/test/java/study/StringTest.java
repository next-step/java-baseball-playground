package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
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
}
