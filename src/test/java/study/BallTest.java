package study;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.Ball;
import baseball.BallStatus;
import baseball.BaseBall;


public class BallTest {
	BaseBall baseBall;

	@BeforeEach
	void setBall() {
		baseBall = new BaseBall();
		Ball oneBall = new Ball(0,"1");
		Ball twoBall = new Ball(1,"4");
		Ball threeBall = new Ball(2,"3");

		List<Ball> computerBallList = new ArrayList<>();
		computerBallList.add(oneBall);
		computerBallList.add(twoBall);
		computerBallList.add(threeBall);

		baseBall.setBall(computerBallList);
	}
	
	@Test
	void isStrike() {
//		String userBall ="1";
//		int position = 0;
//		
//		//스트라이크
//		assertThat(baseBall.isStrike(position, userBall)).isTrue();
//		
//		userBall = "2";
//		position = 1;
//		//노스트라이크
//		assertThat(baseBall.isStrike(position, userBall)).isFalse();
		
		String userBall = "123";
		List<Ball> playerBallList = new ArrayList<>();
		int strike = 0;
		for ( int i = 0; i < userBall.length(); i++ ) {
			Ball playBall = new Ball(i, String.valueOf(userBall.charAt(i)));
			if ( baseBall.isStrike(playBall) ) strike++;
		}
		
		assertThat(strike).isEqualTo(2);
	}
	
	@Test 
	void isBall() {
		String userBall = "437";
		List<Ball> playerBallList = new ArrayList<>();
		int ball = 0;
		for ( int i = 0; i < userBall.length(); i++ ) {
			Ball playBall = new Ball(i, String.valueOf(userBall.charAt(i)));
			if ( baseBall.isBall(playBall) ) ball++;
		}
		
		assertThat(ball).isEqualTo(2);
	}
	
	@Test
	void isNothing() {
		String userBall = "789";
		
		List<Ball> playerBallList = new ArrayList<>();
		int nothing = 0;
		for ( int i = 0; i < userBall.length(); i++ ) {
			Ball playBall = new Ball(i, String.valueOf(userBall.charAt(i)));
			if ( baseBall.isNothing(playBall) ) nothing++;
		}
		assertThat(nothing).isEqualTo(3);
	}
}
