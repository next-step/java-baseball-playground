package com.baseball;

import com.domain.Baseballs;
import com.ui.Output;

public class Result {
    private static final int Count_Zero = 0;
    private int strikeNumber;
    private int ballNumber;

    public Result(Baseballs computerBaseballs, Baseballs userBaseballs){
        strikeNumber = computerBaseballs.countStrike(userBaseballs);
        ballNumber = computerBaseballs.countBall(userBaseballs);
    }

    public String getResult(){
        StringBuilder sb = new StringBuilder();
        if (strikeNumber == Count_Zero && ballNumber == Count_Zero){
            sb.append(Output.RESULT_NOTHING_MESSAGE);
        }
        if (strikeNumber != Count_Zero){
            sb.append(strikeNumber).append(Output.RESULT_STRIKE_MESSAGE);
        }
        if (ballNumber != Count_Zero){
            sb.append(ballNumber).append(Output.RESULT_BALL_MESSAGE);
        }
        return sb.toString();
    }
}
