package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JudgementTest {

    @Test
    void correctCount_0() {
        Judgement judgement = new Judgement();
        List<GameNumber> computer = new ArrayList<>();
        computer.add(new GameNumber(1));
        computer.add(new GameNumber(2));
        computer.add(new GameNumber(3));
        List<GameNumber> user = new ArrayList<>();
        user.add(new GameNumber(4));
        user.add(new GameNumber(5));
        user.add(new GameNumber(6));

        assertThat(judgement.correctCount(computer, user)).isEqualTo(0);
    }

    @Test
    void correctCount_1() {
        Judgement judgement = new Judgement();
        List<GameNumber> computer = new ArrayList<>();
        computer.add(new GameNumber(1));
        computer.add(new GameNumber(2));
        computer.add(new GameNumber(3));
        List<GameNumber> user = new ArrayList<>();
        user.add(new GameNumber(1));
        user.add(new GameNumber(5));
        user.add(new GameNumber(6));

        assertThat(judgement.correctCount(computer, user)).isEqualTo(1);
    }

    @Test
    void correctCount_2() {
        Judgement judgement = new Judgement();
        List<GameNumber> computer = new ArrayList<>();
        computer.add(new GameNumber(1));
        computer.add(new GameNumber(2));
        computer.add(new GameNumber(3));
        List<GameNumber> user = new ArrayList<>();
        user.add(new GameNumber(1));
        user.add(new GameNumber(5));
        user.add(new GameNumber(2));

        assertThat(judgement.correctCount(computer, user)).isEqualTo(2);
    }

    @Test
    void correctCount_3() {
        Judgement judgement = new Judgement();
        List<GameNumber> computer = new ArrayList<>();
        computer.add(new GameNumber(1));
        computer.add(new GameNumber(2));
        computer.add(new GameNumber(3));
        List<GameNumber> user = new ArrayList<>();
        user.add(new GameNumber(1));
        user.add(new GameNumber(3));
        user.add(new GameNumber(2));

        assertThat(judgement.correctCount(computer, user)).isEqualTo(3);
    }

    @Test
    void hasPlace() {
        Judgement judgement = new Judgement();
        List<GameNumber> computer = new ArrayList<>();
        computer.add(new GameNumber(1));
        computer.add(new GameNumber(2));
        computer.add(new GameNumber(3));

        assertThat(judgement.hasPlace(computer, 1, 2)).isTrue();
        assertThat(judgement.hasPlace(computer, 1, 1)).isFalse();
    }
}