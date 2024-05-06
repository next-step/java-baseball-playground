package com.baseball;

import com.domain.BaseballFactory;
import com.domain.Baseballs;
import com.ui.Input;
import com.ui.Output;

public class BaseballGame {
    private Computer computer = new Computer();
    private Baseballs userBaseballs;
    private Baseballs computerBaseballs;

    public void playBaseball(){
        computerBaseballs = computer.generateTandomBaseballs();

        do{
            playBaseballOnce();
        } while(!isCorrectAnswer());
        Output.printCorrectAnswer();
    }

    private void playBaseballOnce(){
        userBaseballs = receiveUserBaseballs();
        Result result = new Result(computerBaseballs, userBaseballs);

        Output.printBaseballGameResult(result.getResult());
    }

    private Baseballs receiveUserBaseballs() {
        try {
            return BaseballFactory.createBaseballs(Input.receiveNumberInput());
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());
            return receiveUserBaseballs();
        }
    }

    private boolean isCorrectAnswer(){
        return userBaseballs.equals(computerBaseballs);
    }
}
