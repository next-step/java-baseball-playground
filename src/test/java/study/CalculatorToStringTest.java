package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorToStringTest {
    CalculatorToString cal;

    @BeforeEach
    public void setUp(){
        cal = new CalculatorToString();
    }
    @Test
    public void add_빈문자열_or_null(){
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

}