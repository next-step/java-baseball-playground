package com.baseball;

import com.ui.Input;
import com.ui.Output;

public class GameManager {
    public void run(){
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.playBaseball();
        } while (isResumeOpinion());

    }

    private boolean isResumeOpinion(){
        try {
            ResumeOrNot opinion = new ResumeOrNot(Input.receiveResumeInput());
            return opinion.isResume();
        } catch (IllegalArgumentException e){
            Output.printExceptionMessage(e.getMessage());
            return isResumeOpinion();
        }
    }
}
