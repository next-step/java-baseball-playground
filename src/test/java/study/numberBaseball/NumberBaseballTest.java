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



}
