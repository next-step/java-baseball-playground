package playbaseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {
	Computer computer;
	@BeforeEach
	void beforeEach() {
		computer = new Computer();
		Ball ball = new Ball(0,"1");
		computer.addBall(ball);
	}
	
	@Test
	void generateNums() {
		Computer computer = new Computer();
		assertThat(computer.generateNums() > 0).isTrue();
		
		assertThat(computer.generateNums() < 10).isTrue();
	}
	
	@Test
	void checkDuplicate() {
		assertThat(computer.checkDuplicate(1)).isTrue();
	}
}
