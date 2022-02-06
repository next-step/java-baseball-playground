import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BaseBallGameManagerTest {

	BaseBallGameManager baseBallGameManager;

	@BeforeEach
	void setUp() {
		baseBallGameManager = new BaseBallGameManager();
	}

	@DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 수가 answer로 생성된다.")
	@Test
	public void test1() {
		//given & when
		Integer[] actual = baseBallGameManager.generateAnswer();

		//then
		assertEquals(3, actual.length);
		assertNotEquals(actual[0], actual[1]);
		assertNotEquals(actual[0], actual[2]);
		assertNotEquals(actual[1], actual[2]);
	}

}