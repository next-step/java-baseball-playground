package study.mission01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("NumberGenerator 객체 무작위 숫자 생성 테스트")
class NumberGeneratorTest {


    @Test
    @DisplayName("3자리의 랜덤 숫자는 서로 달라야 한다.")
    void 세자리_숫자_중복_테스트() {
        int number = NumberGenerator.generate();
        System.out.println("test method - number = " + number);

        int hundred = number / 100;
        int ten = (number % 100) / 10;
        int one = number % 10;

        assertNotEquals(hundred, ten);
        assertNotEquals(hundred, one);
        assertNotEquals(ten, one);
    }
}