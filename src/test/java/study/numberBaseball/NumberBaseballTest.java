package study.numberBaseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.numberBaseball.NumberBaserball;

public class NumberBaseballTest {

    NumberBaserball baserball;

    @BeforeEach
    void init(){
        baserball = new NumberBaserball();
    }

    @Test
    void makeNumber(){
        int actual = baserball.makeNumber();
        Assertions.assertThat(actual).isNotEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value={"121:true", "944:true","631:false", "225:true", "547:false"}, delimiter = ':')
    void hasSameNumber(int num, boolean result){
        boolean actual = baserball.hasSameNumber(num);
        Assertions.assertThat(actual).isEqualTo(result);


    }

    @ParameterizedTest
    @CsvSource(value = {"123:123:0","123:321:2","583:358:3","794:421:1"}, delimiter = ':')
    void countBall(int number, int input, int expected){
        int actual = baserball.countBall(number, input);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123:3","567:561:2","953:243:1","521:251:1"},delimiter = ':')
    void countStrike(int number, int input, int expected){
        int actual = baserball.countStrike(number, input);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:1볼 2스트라이크","2:1:2볼 1스트라이크"
                ,"3:0:3볼", "0:0:아무것도 없습니다."}, delimiter = ':')
    void printResult(int ball, int strike, String expeced){
        String actual = baserball.printResult(ball, strike);
        Assertions.assertThat(actual).matches(expeced);
    }



}
