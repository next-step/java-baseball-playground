package baseball;

import java.util.HashMap;
import java.util.Random;

public class BaseBall {
    public HashMap value = new HashMap<Integer, Integer>();

    public BaseBall() {
        while(value.size() < 3){
            int input_data = (int) (Math.random() * 9) + 1;
            if(!value.containsKey(input_data)){
                value.put(input_data, value.size());
            }
        }
    }

    public JudgeCase judge(int[] input){
        JudgeCase judgeCase = new JudgeCase();
        for(int i =0; i < input.length; i++){
            if(value.containsKey(input[i])){
                if(value.get(input[i]).equals(i)){
                    judgeCase.strike += 1;
                } else{
                    judgeCase.ball += 1;
                }
            }
        }
        return judgeCase;
    }

    public void resetValue(){
        value = new HashMap<Integer, Integer>();
        while(value.size() < 3){
            int input_data = (int) (Math.random() * 9) + 1;
            if(!value.containsKey(input_data)){
                value.put(input_data, value.size());
            }
        }
    }


}

class JudgeCase{
    int strike = 0;
    int ball = 0;

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}