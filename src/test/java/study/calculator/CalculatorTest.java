package study.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator;

    // 생성자 초기화
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void 더하기() {
        assertEquals(5,calculator.add(1,3));
    }

    @Test
    public void 빼기() {
        assertEquals(5,calculator.minus(1,3));
    }

    @Test
    public void 나누기() {
        assertEquals(5,calculator.division(1,3));
    }

    @Test
    public void 나머지() {
        assertEquals(5,calculator.remainder(1,3));
    }

    // 클래스 null 처리
    // 이미 한번 선언한 클래스는 계속 쓰레기 영역에 들어가있기때문임. 메모리 낭비
    @AfterEach
    public void tearDown() {
        calculator = null;
    }

}
