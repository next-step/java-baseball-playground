package baseball.model;

import java.util.List;

public class Judgement {
    private List<Integer> judgeResult;
    public Judgement(List<Integer> list){
        judgeResult = list;
    }

    public int getStrike(){
        return judgeResult.get(0);
    }
    public int getBall(){
        return judgeResult.get(1);
    }
}
