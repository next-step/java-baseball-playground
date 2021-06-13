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
	public boolean isStrike(int position, String playerBall) {
		if ( computerBallList.get(position).getValue() == playerBall ) {
			return true;
		}
		return false;
	}
}
