package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
  StringCalculator stringCalculator;

  public static void inputHandling(String userInput) {
    InputStream in = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(in);
  }

  @Test
  void calculate() {
    inputHandling("2 + 3 * 4 / 2");
    assertThat(stringCalculator.inputString()).isEqualTo(10);
  }

  @BeforeEach
  public void setUp() {
    stringCalculator = new StringCalculator();
  }

  @Test
  public void add() {
    assertEquals(5,stringCalculator.add(2,3));
  }

  @Test
  public void minus() {
    assertEquals(1,stringCalculator.minus(4,3));
  }

  @Test
  public void multiply() {
    assertEquals(12,stringCalculator.multiply(3,4));
  }

  @Test
  public void divide() {
    assertEquals(2,stringCalculator.divide(4,2));
  }

  @Test
  public void operatorCalAdd() {
    int actual = stringCalculator.operatorCal(2,3,"+");
    assertEquals(5,actual);
  }

  @Test
  public void operatorCalMinus() {
    int actual = stringCalculator.operatorCal(4,3,"-");
    assertEquals(1,actual);
  }

  @Test
  public void operatorCalMultiply() {
    int actual = stringCalculator.operatorCal(3,4,"*");
    assertEquals(12,actual);
  }

  @Test
  public void operatorCalDivide() {
    int actual = stringCalculator.operatorCal(4,2,"/");
    assertEquals(2,actual);
  }


}
