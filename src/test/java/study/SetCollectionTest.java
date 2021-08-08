package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {

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
	void getSizeBySetSize() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	void getSizeByHasSize() {
		assertThat(numbers).hasSize(3);
	}

	@Test
	void isContainOneToThree() {
		assertThat(numbers).contains(1);
		assertThat(numbers).contains(2);
		assertThat(numbers).contains(3);

	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3}) // go to Parameter
	void isContainOneToThreeCheckTrue(int valueSource) {
		assertTrue(numbers.contains(valueSource));
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void isContainOneToThreeCheckTrueOrFalse(String number, String expected) {
		String isContain = numbers.contains(Integer.parseInt(number)) ? "true" : "false";
		assertEquals(expected, isContain);
	}

}
