package baseball;

import ui.InputView;
import ui.ResultView;
import utils.MakeRandomNum;

import java.util.List;
import java.util.Scanner;

import static baseball.BallsNumber.validateNumber;

public class BaseBall {
    public void game(){
        // computer num
        MakeRandomNum randomNum = new MakeRandomNum();
        Balls answer = new Balls(randomNum.makeRandomNum());

        // user num
        Scanner sc = new Scanner(System.in);
        int strike = 0;

        while(strike != 3) {
            System.out.print("숫자를 입력해 주세요 : ");
            int userInput = sc.nextInt();

            // 유효성 검사
            BallsNumber ball = new BallsNumber();

            List<Integer> ballList = ball.splitNumber(userInput);
            if(!validateNumber(ballList)) continue;

            strike = ResultView.result(answer.play(ballList));
        }

    }
    public BaseBall() {
        while(true){
            game();
            if(InputView.inputNumber()!=1) return;
        }
    }

    public static void main(String[] args) {
        new BaseBall();
    }
}
