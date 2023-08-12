package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RefereeTest {

    @Test
    void 스트라이크3_테스트() {
        Referee referee = new Referee();
        List<GameNumber> computer = new ArrayList<>();
        computer.add(new GameNumber(1));
        computer.add(new GameNumber(2));
        computer.add(new GameNumber(3));
        List<GameNumber> user = new ArrayList<>();
        user.add(new GameNumber(1));
        user.add(new GameNumber(2));
        user.add(new GameNumber(3));
        GameStatus gameStatus = referee.compare(computer, user);

        Assertions.assertThat(gameStatus.getStrike()).isEqualTo(3);
        Assertions.assertThat(gameStatus.getBall()).isEqualTo(0);
    }

    @Test
    void 낫싱_테스트() {
        Referee referee = new Referee();
        List<GameNumber> computer = new ArrayList<>();
        computer.add(new GameNumber(1));
        computer.add(new GameNumber(2));
        computer.add(new GameNumber(3));
        List<GameNumber> user = new ArrayList<>();
        user.add(new GameNumber(4));
        user.add(new GameNumber(5));
        user.add(new GameNumber(6));
        GameStatus gameStatus = referee.compare(computer, user);

        Assertions.assertThat(gameStatus.getStrike()).isEqualTo(0);
        Assertions.assertThat(gameStatus.getBall()).isEqualTo(0);
    }

    @Test
    void N볼_N스트라이크_테스트() {
        Referee referee = new Referee();
        List<GameNumber> computer = new ArrayList<>();
        computer.add(new GameNumber(1));
        computer.add(new GameNumber(2));
        computer.add(new GameNumber(3));
        List<GameNumber> user = new ArrayList<>();
        user.add(new GameNumber(1));
        user.add(new GameNumber(3));
        user.add(new GameNumber(6));
        GameStatus gameStatus = referee.compare(computer, user);

        Assertions.assertThat(gameStatus.getStrike()).isEqualTo(1);
        Assertions.assertThat(gameStatus.getBall()).isEqualTo(1);

        user = new ArrayList<>();
        user.add(new GameNumber(2));
        user.add(new GameNumber(3));
        user.add(new GameNumber(1));
        gameStatus = referee.compare(computer, user);

        Assertions.assertThat(gameStatus.getStrike()).isEqualTo(0);
        Assertions.assertThat(gameStatus.getBall()).isEqualTo(3);

        user = new ArrayList<>();
        user.add(new GameNumber(1));
        user.add(new GameNumber(8));
        user.add(new GameNumber(3));
        gameStatus = referee.compare(computer, user);

        Assertions.assertThat(gameStatus.getStrike()).isEqualTo(2);
        Assertions.assertThat(gameStatus.getBall()).isEqualTo(0);
    }
}