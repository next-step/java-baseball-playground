package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballTest {

    Baseball baseball = new Baseball();
    private int[] answer = new int[3];

    @DisplayName("중복 테스트 메소드 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:1:false", "1:2:true"}, delimiter = ':')
    void doubleCheckTest(int createNumber, int checkNumber, boolean expected) {
        assertThat(baseball.doubleCheck(createNumber, checkNumber)).isEqualTo(expected);
    }

    @DisplayName("삼중 중복 확인 메소드 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3:true", "1:1:2:false", "1:2:1:false", "1:1:1:false"}, delimiter = ':')
    void treepleCheckTest(int createNumber, int checkNumberOne, int checkNumberTwo,
        boolean expected) {
        assertThat(baseball.threepleCheck(createNumber, checkNumberOne, checkNumberTwo)).isEqualTo(
            expected);
    }

    @DisplayName("세번째 랜덤 숫자 생성 메소드 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "3:4"}, delimiter = ':')
    void setThirdNumber(int first, int second) {
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
    void setUpAnswerTest() {
        int[] answer = new int[3];
        answer = baseball.setUpAnswer();
        assertThat(answer[0] > 0 && answer[0] < 10);
        assertThat(baseball.threepleCheck(answer[0], answer[1], answer[2])).isTrue();
    }

    @BeforeEach
    void setUp() {
        answer[0] = 4;
        answer[1] = 5;
        answer[2] = 6;
    }

    @DisplayName("첫번째 공 확인 메소드 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:0:0", "4:1:0", "5:0:1", "6:0:1", "7:0:0"}, delimiter = ':')
    void checkFirstBallTest(int firstInputString, int expectedStrike, int expectedBall) {
        baseball.checkFirstBall(answer, firstInputString);
        assertThat(baseball.roundElement.strike).isEqualTo(expectedStrike);
        assertThat(baseball.roundElement.ball).isEqualTo(expectedBall);
    }

    @DisplayName("두번째 공 확인 메소드 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:0:0", "4:0:1", "5:1:0", "6:0:1", "7:0:0"}, delimiter = ':')
    void checkSecondBallTest(int secondInputString, int expectedStrike, int expectedBall) {
        baseball.checkSecondBall(answer, secondInputString);
        assertThat(baseball.roundElement.strike).isEqualTo(expectedStrike);
        assertThat(baseball.roundElement.ball).isEqualTo(expectedBall);
    }

    @DisplayName("세번째 공 확인 메소드 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:0:0", "4:0:1", "5:0:1", "6:1:0", "7:0:0"}, delimiter = ':')
    void checkThirdBallTest(int thirdInputString, int expectedStrike, int expectedBall) {
        baseball.checkThirdBall(answer, thirdInputString);
        assertThat(baseball.roundElement.strike).isEqualTo(expectedStrike);
        assertThat(baseball.roundElement.ball).isEqualTo(expectedBall);
    }

    @DisplayName("3개 공 합산 스트라이크 볼 갯수 확인 테스트 구현")
    @ParameterizedTest
    @CsvSource(value = {"456:3:0", "457:2:0", "465:1:2", "435:1:1", "789:0:0",
        "512:0:1", "542:0:2", "645:0:3"}, delimiter = ':')
    void parseRoundTest(String inputString, int expectedStrike, int expectedBall) {
        baseball.parseRound(answer, inputString);
        assertThat(baseball.roundElement.strike).isEqualTo(expectedStrike);
        assertThat(baseball.roundElement.ball).isEqualTo(expectedBall);
    }

}

