package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


	@Nested
	@DisplayName("요구사항1")
	class Requirement1 {
		@Test
		@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
		public void size_test1() {
			int given = numbers.size();

			assertEquals(4, given);
		}
	}


	@Nested
	@DisplayName("요구사항2")
	class Requirement2 {
		@ParameterizedTest
		@ValueSource(ints = {1,2,3})
		@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다")
		public void contains_test1(int expected) {
			boolean given = numbers.contains(expected);
			assertTrue(given);
		}
	}

	@Nested
	@DisplayName("요구사항3")
	class Requirement3 {
		@ParameterizedTest
		@CsvSource({"1,true","2,true","3,true","4,false","5,false"})
		@DisplayName("요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.")
		public void contains_complex_test1(int given, boolean expected) {
			boolean actual = numbers.contains(given);
			assertEquals(actual, expected);
		}
	}
}

