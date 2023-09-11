package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PitchTest {
    List<Ball> answer;
    @BeforeEach
    void setAnswer() {
        answer = new Balls(new InputNumberSupplier("123")).getBallList();
    }

    @Test
    @DisplayName("1볼의 결과를 잘 출력하는지를 확인합니다.")
    void getPitchResult_1Ball_true() {
        List<Ball> user = new Balls(new InputNumberSupplier("415")).getBallList();
        Pitch pitch = new Pitch(answer, user);
        PitchResult pitchResult = pitch.getPitchResult();

        assertThat(pitchResult.report()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("2볼의 결과를 잘 출력하는지를 확인합니다.")
    void getPitchResult_2Ball_true() {
        List<Ball> user = new Balls(new InputNumberSupplier("315")).getBallList();
        Pitch pitch = new Pitch(answer, user);
        PitchResult pitchResult = pitch.getPitchResult();

        assertThat(pitchResult.report()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("1스트라이크의 결과를 잘 출력하는지를 확인합니다.")
    void getPitchResult_1Strike_true() {
        List<Ball> user = new Balls(new InputNumberSupplier("145")).getBallList();
        Pitch pitch = new Pitch(answer, user);
        PitchResult pitchResult = pitch.getPitchResult();

        assertThat(pitchResult.report()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("2스트라이크의 결과를 잘 출력하는지를 확인합니다.")
    void getPitchResult_2Strike_true() {
        List<Ball> user = new Balls(new InputNumberSupplier("125")).getBallList();
        Pitch pitch = new Pitch(answer, user);
        PitchResult pitchResult = pitch.getPitchResult();

        assertThat(pitchResult.report()).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("2볼 1스트라이크의 결과를 잘 출력하는지를 확인합니다.")
    void getPitchResult_2BallAnd1Strike_true() {
        List<Ball> user = new Balls(new InputNumberSupplier("321")).getBallList();
        Pitch pitch = new Pitch(answer, user);
        PitchResult pitchResult = pitch.getPitchResult();

        assertThat(pitchResult.report()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("3스트라이크의 결과를 잘 출력하는지를 확인합니다.")
    void getPitchResult_3Strike_true() {
        List<Ball> user = new Balls(new InputNumberSupplier("123")).getBallList();
        Pitch pitch = new Pitch(answer, user);
        PitchResult pitchResult = pitch.getPitchResult();

        assertThat(pitchResult.report()).isEqualTo("3스트라이크");
        assertThat(pitchResult.isStrikeOut(3)).isTrue();
    }
}