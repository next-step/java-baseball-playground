package study.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckBaseballNumbersTest {

	private CheckBaseballNumbers cbn;
	private Baseball baseball;
	
	@BeforeEach
	public void setUp() {
		cbn = new CheckBaseballNumbers();
	}
	
	@DisplayName("스트라이크 확인")
	@Test
	public void strikeTest() {
		int[] list = {1, 0, 0};
		
		for (int i=0; i<3; i++) {
			assertThat(list[i]).isEqualTo(cbn.checkStrike("356", "362", i));			
		}
	}
	
	@DisplayName("스트라이크, 볼 확인")
	@Test
	public void strikeAndBallTest() {
		baseball = new Baseball(1, 2);
		assertThat(baseball.getStrike()).isEqualTo(cbn.checkBallAndStrike("312", "321").getStrike());
		assertThat(baseball.getBall()).isEqualTo(cbn.checkBallAndStrike("312", "321").getBall());
	}
	
	@DisplayName("볼 확인")
	@Test
	public void ballTest() {
		int[] list = {1, 0, 0};
		for (int i=0; i<3; i++) {
			assertThat(list[i]).isEqualTo(cbn.checkBall("136", "392", i));			
		}
	}
	
}
