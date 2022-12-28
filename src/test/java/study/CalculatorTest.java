package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Scanner;

public class CalculatorTest {

	Calculator cal;

	@BeforeEach
	public void setUp() {
		cal = new Calculator();
	}
	
	@DisplayName("더하기 테스트")
	@Test
	public void addTest() {
		assertThat(10).isEqualTo(cal.add(4, 6));
	}
	
	@DisplayName("빼기 테스트")
	@Test
	public void subTest() {
		assertThat(10).isEqualTo(cal.subtract(11, 1));
	}
	
	@DisplayName("곱하기 테스트")
	@Test
	public void multiTest() {
		assertThat(12).isEqualTo(cal.multiply(4, 3));
	}
	
	@DisplayName("나누기 테스트")
	@Test
	public void divTest() {
		assertThat(10).isEqualTo(cal.divide(20, 2));
	}
	
	@DisplayName("문자열 나누기")
	@Test
	void sepString() {
		String str = "5 + 5";
		String[] result = {"5", "+", "5"};
		assertThat(result).isEqualTo(cal.seperate(str));
	}
	
	@DisplayName("문자열 계산기")
	@Test
	void calString() {
		String str = "5 + 5 - 3 + 2 * 2 / 3";
		String[] result = cal.seperate(str);
		int ans = 6;
		
		assertThat(ans).isEqualTo(cal.calString(result));
	}
	
}
