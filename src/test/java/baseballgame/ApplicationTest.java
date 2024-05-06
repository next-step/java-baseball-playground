package baseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    @DisplayName("Test Duplication in com_num")
    public void com_num_Dup_test(){
        //given
        List<Integer> com_num;

        //when
        ComputerNum computer = new ComputerNum();
        com_num = computer.ComputerNumber();

        //then
        assertNotEquals(com_num.get(0),com_num.get(1));
        assertNotEquals(com_num.get(1),com_num.get(2));
        assertNotEquals(com_num.get(0),com_num.get(2));
    }

    @Test
    @DisplayName("3Strike Test")
    public void strike3Test(){
        List<Integer> test1 = Arrays.asList(1,2,3);
        List<Integer> test2 = Arrays.asList(1,2,3);

        Compare compare = new Compare();

        assertEquals("3strike", compare.Compare_num(test1,test2));
    }

    @Test
    @DisplayName("3ball Test")
    public void ball3Test(){
        List<Integer> test1 = Arrays.asList(1,2,3);
        List<Integer> test2 = Arrays.asList(2,3,1);

        Compare compare = new Compare();

        assertEquals("3ball", compare.Compare_num(test1,test2));
    }

    @Test
    @DisplayName("nothing Test")
    public void nothingTest(){
        List<Integer> test1 = Arrays.asList(1,2,3);
        List<Integer> test2 = Arrays.asList(4,5,6);

        Compare compare = new Compare();

        assertEquals("nothing", compare.Compare_num(test1,test2));
    }

    @Test
    @DisplayName("N Strike 0 Ball Test")
    public void NStrike0BallTest(){
        List<Integer> test1 = Arrays.asList(1,2,3);
        List<Integer> test2 = Arrays.asList(1,5,6);

        Compare compare = new Compare();

        assertEquals("1strike", compare.Compare_num(test1,test2));
    }

    @Test
    @DisplayName("0 Strike N Ball Test")
    public void NBall0StrikeTest(){
        List<Integer> test1 = Arrays.asList(1,2,3);
        List<Integer> test2 = Arrays.asList(5,1,6);

        Compare compare = new Compare();

        assertEquals("1ball", compare.Compare_num(test1,test2));
    }

    @Test
    @DisplayName("N Strike N Ball Test")
    public void NStrikeNBallTest(){
        List<Integer> test1 = Arrays.asList(1,2,3);
        List<Integer> test2 = Arrays.asList(1,6,2);

        Compare compare = new Compare();

        assertEquals("1ball 1strike", compare.Compare_num(test1,test2));
    }

    @Test
    @DisplayName("player input exception test")
    public void testLength_exception_whenInputLengthIsGreaterThanThree() {
        playgame playgame = new playgame();

        try {
            playgame.Length_exception("1234");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Not a three digit number", e.getMessage());
        }
    }

    @Test
    public void testLength_exception_whenInputLengthIsThree() {
        playgame playgame = new playgame();
        try {
            playgame.Length_exception("123");
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException");
        }
    }

    @Test
    public void testLength_exception_whenInputLengthIsLessThanThree() {
        playgame playgame = new playgame();
        try {
            playgame.Length_exception("12");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Not a three digit number", e.getMessage());
        }
    }

    @Test
    public void testRestart_Input1() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Regame regame = new Regame();
        boolean result = regame.restart();

        assertTrue(result);
    }

    @Test
    public void testRestart_whenInputIs2() {
        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Regame regame = new Regame();
        boolean result = regame.restart();

        assertFalse(result);
    }

    @Test
    public void testRestart_whenInputIsInvalid() {
        String input = "3"; // Invalid input
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Regame regame = new Regame();

        try {
            regame.restart();
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("enter 1 or 2", e.getMessage());
        }
    }



}