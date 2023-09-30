import checker.BaseballChecker;
import checker.CheckEnum;
import checker.CountVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheckerTest {
    BaseballChecker checker;
    @BeforeEach
    void init(){
        checker = new BaseballChecker("321");
    }
    @Test
    void strikeTest() {
        CheckEnum checkEnum = checker.checkGuess("1", "1");
        assertThat(checkEnum).isEqualTo(CheckEnum.STRIKE);
    }

    @Test
    void nothingTest(){
        CheckEnum checkEnum = checker.checkGuess("1", "8");
        assertThat(checkEnum).isEqualTo(CheckEnum.NOTHING);
    }

    @Test
    void ballTest(){
        CheckEnum checkEnum = checker.checkGuess("321", "1");
        assertThat(checkEnum).isEqualTo(CheckEnum.BALL);
    }

    @Test
    void nothing_ofAll(){
        checker.evaluateGuess( "789");
        assertThat(checker.getResult()).isEqualTo(new CountVO(0, 0));

    }

    @Test
    void one_ball_one_strike() {
        checker.evaluateGuess( "316");
        assertThat(checker.getResult()).isEqualTo(new CountVO(1, 1));
    }

    @Test
    void three_strike(){
        checker.evaluateGuess( "321");
        assertThat(checker.getResult()).isEqualTo(new CountVO(3, 0));
    }

    @Test
    void three_ball(){
        checker.evaluateGuess("132");
        assertThat(checker.getResult()).isEqualTo(new CountVO(0, 3));
    }
}
