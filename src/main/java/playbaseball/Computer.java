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
		initBall();
	}
	
	public List<Ball> getBallList() {
		return ballList;
	}
	
	public void addBall(Ball ball) {
		ballList.add(ball);
	}
	
	public void initBall() {
		while( ballList.size() < 3 ) {
			int num = generateNums();
			if ( !checkDuplicate(num) ) {
				Ball ball = new Ball(String.valueOf(num));
				addBall(ball);
			}
		}
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
