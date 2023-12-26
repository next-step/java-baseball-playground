package baseball.model;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RefereeTest {
    @Test
    @DisplayName("컴퓨터와 사용자의 숫자를 비교하여 볼 갯수와 스트라이크 갯수를 반환한다.")
    void twoBallOneStrike() {
        //given
        List<Integer> computerNumbers = new ArrayList<>();
        List<Integer> userNumbers = new ArrayList<>();

        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);

        userNumbers.add(1);
        userNumbers.add(3);
        userNumbers.add(2);

        BaseballNumbers computerBaseballNumbers = new BaseballNumbers(computerNumbers);
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(userNumbers);

        //when
        Referee referee = new Referee(computerBaseballNumbers, userBaseballNumbers);

        //then
        Assertions.assertThat(referee.getBall()).isEqualTo(2);
        Assertions.assertThat(referee.getStrike()).isEqualTo(1);
    }
}