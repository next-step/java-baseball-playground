package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballTest {

    Baseball baseball = new Baseball();

    @DisplayName("중복 테스트 메소드 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:1:false", "1:2:true"}, delimiter = ':')
    void doubleCheckTest(int createNumber, int checkNumber, boolean expected) {
        assertThat(baseball.doubleCheck(createNumber, checkNumber)).isEqualTo(expected);
    }

    @DisplayName("삼중 중복 확인 메소드 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3:true", "1:1:2:false", "1:2:1:false", "1:1:1:false"}, delimiter = ':')
    void treepleCheckTest(int createNumber, int checkNumberOne, int checkNumberTwo, boolean expected){
        assertThat(baseball.threepleCheck(createNumber, checkNumberOne, checkNumberTwo)).isEqualTo(expected);
    }

    @DisplayName("세번째 랜덤 숫자 생성 메소드 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "3:4"}, delimiter = ':')
    void setThirdNumber(int first, int second){
        assertThat(baseball.setThirdNumber(first, second) > 0 &&
            baseball.setThirdNumber(first, second) < 10);
    }

    @DisplayName("두번째 랜덤 숫자 생성 메소드 테스트 구현")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void setSecondNumberTest(int first) {
        assertThat(baseball.setSecondNumber(first) > 0 &&
            baseball.setSecondNumber(first) < 10);
    }

    @DisplayName("숫자 야구 랜덤 숫자 생성 메소드 테스트 구현")
    @Test
    void setUpAnswerTest(){
        int[] answer = new int[3];
        answer = baseball.setUpAnswer();
        assertThat(answer[0] > 0 && answer[0] < 10);
        assertThat(baseball.threepleCheck(answer[0], answer[1], answer[2])).isTrue();
    }
}

