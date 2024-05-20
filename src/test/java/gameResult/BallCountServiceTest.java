package gameResult;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

public class BallCountServiceTest {

    private BallCountService ballCountService;

    @BeforeEach
    public void setUp() {
        ballCountService = new BallCountService();
    }

    @Test
    @DisplayName("1볼 카운트 테스트")
    public void ballCountTest_one() {
        int [] answer = {3,2,8};
        int [] input = {2,5,8};
        int ball = 1;

        int result = ballCountService.ballCount(answer, input);
        assertThat(result).isEqualTo(ball);
    }

    @Test
    @DisplayName("0볼 카운트 테스트")
    public void ballCountTest_zero() {
        int [] answer = {1,2,3};
        int [] input = {4,5,6};
        int ball = 0;

        int result = ballCountService.ballCount(answer, input);
        assertThat(result).isEqualTo(ball);
    }

    @Test
    @DisplayName("2볼 카운트 테스트")
    public void ballCountTest_two() {
        int [] answer = {1,2,3};
        int [] input = {2,3,4};
        int ball = 2;

        int result = ballCountService.ballCount(answer, input);
        assertThat(result).isEqualTo(ball);
    }

    @Test
    @DisplayName("3볼 카운트 테스트")
    public void ballCountTest_three() {
        int [] answer = {1,2,3};
        int [] input = {3,1,2};
        int ball = 3;

        int result = ballCountService.ballCount(answer, input);
        assertThat(result).isEqualTo(ball);
    }

    @Test
    @DisplayName("input만 카운트")
    public void countInputBallCompareAnswerElement() {
        int answer = 1;
        int answerIdx = 0;
        int [] input = {9,2,1};
        int ballPerOneAnswer = 1;

        int result = ballCountService.countInputBallCompareAnswerElement(answer,input,answerIdx);
        assertThat(result).isEqualTo(ballPerOneAnswer);
    }

    @Test
    @DisplayName("input만 카운트(strike만 있는 경우)")
    public void countInputBallCompareAnswerElement_strike_case() {
        int answer = 1;
        int answerIdx = 2;
        int [] input = {9,2,1};
        int ballPerOneAnswer = 0;

        int result = ballCountService.countInputBallCompareAnswerElement(answer,input,answerIdx);
        assertThat(result).isEqualTo(ballPerOneAnswer);
    }

    @Test
    @DisplayName("볼인지 체크 (볼인 경우)")
    public void checkBall_isBall(){
        int answerElement = 4;
        int answerIdx = 0;
        int inputElement = 4;
        int inputIdx = 2;

        int ball = ballCountService.checkBall(answerElement,inputElement,answerIdx, inputIdx);
        assertThat(ball).isEqualTo(1);
    }

    @Test
    @DisplayName("볼인지 체크 (볼 아닌 경우)")
    public void checkBall_isNotBall(){
        int answerElement = 1;
        int answerIdx = 0;
        int inputElement = 4;
        int inputIdx = 2;

        int ball = ballCountService.checkBall(answerElement,inputElement,answerIdx, inputIdx);
        assertThat(ball).isEqualTo(0);
    }

    @Test
    @DisplayName("볼인지 체크 (볼 아닌 경우 - 숫자는 같지만 스트라이크인 케이스)")
    public void checkBall_isNotBall_strike(){
        int answerElement = 4;
        int answerIdx = 0;
        int inputElement = 4;
        int inputIdx = 0;

        int ball = ballCountService.checkBall(answerElement,inputElement,answerIdx, inputIdx);
        assertThat(ball).isEqualTo(0);
    }
}
