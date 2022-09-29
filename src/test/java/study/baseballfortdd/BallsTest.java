package study.baseballfortdd;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    public List<Ball> computerBalls;
    public List<Ball> userBalls;
    @BeforeEach
    void settingBalls(){
        computerBalls = Arrays
                        .asList(new Ball(3,1),new Ball(5,2),new Ball(2,3));
        userBalls = Arrays
                        .asList(new Ball(2,1),new Ball(4,2),new Ball(2,3));

    }

    @Test
    @DisplayName("세개의 공 만들기")
    void 세개의_공_만들기(){
        String num = "123";
        org.junit.jupiter.api.Assertions.assertThrows( IllegalArgumentException.class, () -> new MakeBall(num));

    }


    @Test
    @DisplayName("여러개의 볼을 테스트 했을 경우")
    void 여러개의볼_스트라이크_테스트(){
        // stream 써보기?
        PlayResult playResult = new PlayResult();

        assertThat(playResult.coutStrike(computerBalls,userBalls)).isEqualTo(1);

    }

    @Test
    @DisplayName("여러개의 볼을 테스트 했을 경우")
    void 여러개의볼_볼_테스트(){
        // 넘버만 비교한다 나랑 위치가 다른 볼들만 비교하기
        PlayResult pr = new PlayResult();
        pr.compare(computerBalls,userBalls);
    }

    @Test
    @DisplayName("여러개의 볼을 테스트 했을 경우")
    void 여러개의볼_낫띵_테스트(){
        userBalls = Arrays
                .asList(new Ball(2,1),new Ball(4,2),new Ball(3,3));
        List<Ball> resultBallBalls = computerBalls.stream()
                .filter( comball -> userBalls.stream().noneMatch(Predicate.isEqual(comball))).collect(Collectors.toList());
        assertThat(resultBallBalls.size()).isEqualTo(3);
    }
}
