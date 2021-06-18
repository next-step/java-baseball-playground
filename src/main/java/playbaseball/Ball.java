package playbaseball;

public class Ball {
	private int position;
	private String value;
	private BallStatus ballStatus;
	
	public Ball(String value) {
		this.position++;
		this.value = value;
	}
	
	public Ball(int position, String value) {
		this.position = position;
		this.value = value;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public BallStatus getBallStatus() {
		return ballStatus;
	}
	public void setBallStatus(BallStatus ballStatus) {
		this.ballStatus = ballStatus;
	}
}
