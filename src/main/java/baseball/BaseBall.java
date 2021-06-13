package baseball;

import java.util.List;

public class BaseBall {
	private List<Ball> computerBallList;
	
	public void setBall(List<Ball> computerBallList) {
		this.computerBallList = computerBallList;
	}
	
	//값이 같아야함
	//포지션이 같아야함
	//스트라이크가 아니라면 볼이다.
	public boolean isStrike(Ball playerBall) {
		return computerBallList.stream()
				.filter(one -> one.getValue().equals(playerBall.getValue()) )
				.anyMatch(one -> one.getPosition() == playerBall.getPosition());
	}
	
	//포지션은 다르지만 값은 포함되어있다
	public boolean isBall(Ball playerBall) {
		return computerBallList.stream()
				.filter(one -> one.getValue().equals(playerBall.getValue()) )
				.anyMatch(one -> one.getPosition() != playerBall.getPosition());
	}
}
