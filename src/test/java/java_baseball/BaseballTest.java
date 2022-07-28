package java_baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

// [O] 1부터 9까지의 서로 다른 임의의 수 3개를 생성한다.
// [O] 컴퓨터의 수(3자리)와 플레이어의 수(3자리)를 비교할 수 있다.
//  - [O] 몇개의 숫자가 같은지를 알 수 있다.
//  - [O] 같은 수가 다른 자리에 있으면 볼이다.
//  - [O] 같은 수가 같은 자리에 있으면 스트라이크이다.
//  - [O] 같은 수가 전혀 없으면 낫싱이다.
public class BaseballTest {

    @Test
    @DisplayName("서로다른 임의의 수 3개 생성")
    public void init_random_number() {
        Baseball game = new Baseball();
        game.createRandomNumber();
        assertThat(Baseball.answers.get(0)).isNotEqualTo(Baseball.answers.get(1)).isNotEqualTo(Baseball.answers.get(2));
        assertThat(Baseball.answers.get(1)).isNotEqualTo(Baseball.answers.get(2));
    }

    @Test
    @DisplayName("컴퓨터의 숫자와 사용자의 입력값이 몇개가 같은지 확인")
    public void compare_number_computer_user() {
        Baseball game = new Baseball();
        Baseball.answers.add(1);
        Baseball.answers.add(2);
        Baseball.answers.add(3);
        game.createUserInput("123");
        int result = game.compare();
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("strike 수 구하기")
    public void getStrike() {
        Baseball game = new Baseball();
        Baseball.answers.add(1);
        Baseball.answers.add(2);
        Baseball.answers.add(3);
        game.createUserInput("123");
        int result = game.getStrike();
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("ball 수 구하기")
    public void getBall() {
        Baseball game = new Baseball();
        Baseball.answers.add(1);
        Baseball.answers.add(2);
        Baseball.answers.add(3);
        game.createUserInput("123");
        int result = game.getBall();
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("결과 값 print")
    public void getResult() {
        Baseball game = new Baseball();
        Baseball.answers.add(1);
        Baseball.answers.add(2);
        Baseball.answers.add(3);
        game.createUserInput("456");
        game.makeResult();
    }

}
