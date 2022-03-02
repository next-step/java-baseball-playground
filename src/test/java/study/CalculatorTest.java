package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        assertTrue( true, "setup");
    }

    @Test
    public void test1() {
        assertTrue( false, "test1");
    }

    @Test
    public void test2() {
        assertTrue( true, "test2");
    }

    @AfterEach
    public void tearDown() {
        assertTrue( true, "tearDown");
    }



}
