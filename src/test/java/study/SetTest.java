package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class SetTest {

	private Set<Integer> numbers;
	
	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}
	
	@Test
	void size() {
		assertThat(numbers).hasSize(3);
	}
	
	@DisplayName("number 포함 체크")
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void isContainNumbers(int number) {
		assertThat(numbers).contains(number);
	}
	
	@DisplayName("true, false 체크")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void isBooleanNumbers(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}
	
	
}
