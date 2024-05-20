package gameResult;

import jdk.internal.org.jline.utils.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResultTest {

    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUpStreams() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    protected String getOutput() {
        // ByteArrayOutputStream의 toString은 기본 문자집합을 사용하여 버퍼의 내용을 문자열 디코딩 바이트로 변환해줍니다.
        return outputStreamCaptor.toString();
    }

    @Test
    @DisplayName("기본 게임결과 객체 생성")
    public void createDefaultGameResult() {
        GameResult gameResult = GameResult.createDefaultGameResult();

        assertThat(gameResult.getBall()).isEqualTo(0);
        assertThat(gameResult.getStrike()).isEqualTo(0);
    }

    @Test
    @DisplayName("3 스트라이느(이긴 경우) 테스트")
    public void isWin_win(){
        GameResult gameResult = new GameResult(0,3);

        assertThat(gameResult.isWin()).isTrue();
    }

    @Test
    @DisplayName("3 스트라이느(진 경우) 테스트")
    public void isWin_loose(){
        GameResult gameResult = new GameResult(3,0);

        assertThat(gameResult.isWin()).isFalse();
    }

    @Test
    @DisplayName("게임결과 출력 테스트_스트라이크만 있는 경우")
    public void printGameResult_strikeOnly() {
        int strike = 1;
        int ball = 0;
        GameResult gameResult = new GameResult(ball,strike);

        gameResult.printGameResult();

        assertThat(getOutput()).contains(strike+"스트라이크");
        assertThat(getOutput()).doesNotContain("볼");
    }

    @Test
    @DisplayName("게임결과 출력 테스트_스트라이크 있고 이긴 경우")
    public void printGameResult_strikeOnlyWin() {
        int strike = 3;
        int ball = 0;
        GameResult gameResult = new GameResult(ball ,strike);

        gameResult.printGameResult();

        assertThat(getOutput()).contains(strike+"스트라이크");
        assertThat(getOutput()).contains("개의 숫자를 모두 맞히셨습니다! 게임종료");
        assertThat(getOutput()).doesNotContain("볼");
    }

    @Test
    @DisplayName("게임결과 출력 테스트_볼만 있는 경우")
    public void printGameResult_ballOnly() {
        int strike = 0;
        int ball = 1;
        GameResult gameResult = new GameResult(ball,strike);

        gameResult.printGameResult();

        assertThat(getOutput()).contains(ball+"볼");
        assertThat(getOutput()).doesNotContain("스트라이크");
    }

    @Test
    @DisplayName("게임결과 출력 테스트_스트라이크, 볼 있는 경우")
    public void printGameResult_strikeAndBall() {
        int strike = 1;
        int ball = 1;
        GameResult gameResult = new GameResult(ball,strike);

        gameResult.printGameResult();

        assertThat(getOutput()).contains(ball+"볼");
        assertThat(getOutput()).contains(strike+"스트라이크");
    }

    @Test
    @DisplayName("이긴 경우 출력 테스트")
    public void printWhenWinGame() {
        int strike = 3;
        int ball = 0;
        GameResult gameResult = new GameResult(ball,strike);

        gameResult.printWhenWinGame();

        assertThat(getOutput()).contains("개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

}
