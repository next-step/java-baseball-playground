package baseball.domain;

import baseball.domain.Ball;
import baseball.domain.UserBalls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserBallsTest {

    @DisplayName("UserBalls OK")
    @ParameterizedTest
    @ValueSource(strings = {"123","459","986"})
    void are_UserBalls(String input){
        UserBalls userBalls = new UserBalls(input);
        assertThat(userBalls).isInstanceOf(UserBalls.class);
        assertThat(userBalls.getUserBallList().get(0)).isInstanceOf(Ball.class);
    }

    @DisplayName("UserBalls Input Not 3 ")
    @ParameterizedTest
    @ValueSource(strings = {"1343","6786"})
    void not_3_InUserBalls(String input){
        assertThatThrownBy(() ->
                new UserBalls(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not 3 numbers");
    }

    @DisplayName("UserBalls Not Distinct 3 ")
    @ParameterizedTest
    @ValueSource(strings = {"133","686"})
    void not_3_DistinctUserBalls(String input){
        assertThatThrownBy(() ->
            new UserBalls(input)).isInstanceOf(IllegalArgumentException.class)
                                    .hasMessageContaining("Not Distinct 3 numbers");
    }

    @DisplayName("UserBall Not OK")
    @ParameterizedTest
    @ValueSource(strings = {"109","098"})
    void not_UserBall(String input){
        assertThatThrownBy(() ->
                new UserBalls(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("isNotInRange");
    }
}
