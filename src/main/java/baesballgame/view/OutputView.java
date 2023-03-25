package baesballgame.view;

import baesballgame.model.computer.dto.ResponseResult;

public class OutputView {

    public void output(ResponseResult responseResult) {
        int ball = responseResult.getBall();
        int strike = responseResult.getStrike();

        if (ball != 0) {
            System.out.print(String.format("%d볼 ", ball));
        }

        if (strike != 0) {
            System.out.print(String.format("%d스트라이크", strike));
        }

        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }

        System.out.println();
    }
}