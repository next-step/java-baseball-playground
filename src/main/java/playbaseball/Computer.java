package playbaseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
	private static final int MIN = 1;
	private static final int MAX = 9;
	private List<Ball> ballList;
	
	public Computer() {
		ballList = new ArrayList<>();
	}
	
	public void addBall(Ball ball) {
		ballList.add(ball);
	}
	
	public int generateNums() {
		Random random = new Random();
		return random.nextInt(MAX)+MIN;
	}

	public boolean checkDuplicate(int num) {
		return ballList.stream()
				.anyMatch(oneBall -> oneBall.getValue().equals(String.valueOf(num)));
	}
}
