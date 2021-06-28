package study;

import java.util.List;

public class BaseBallGame {

    public static ResultDTO play(Balls computer, Balls answer) {
        List<Ball> answerList = answer.getList();
        List<Ball> computerList = computer.getList();
        ResultDTO resultDTO = new ResultDTO();
        for (int i=0;i<computerList.size();i++) {
            Ball answerElement =  answerList.get(i);
            ResultType resultType = answerElement.getStatus(computerList);
            if (resultType.equals(ResultType.BALL)) {
                resultDTO.ballValue += 1;
             } else if (resultType.equals(ResultType.STRIKE)) {
                resultDTO.strikeValue += 1;
            }
        }
        return resultDTO;
    }
}
