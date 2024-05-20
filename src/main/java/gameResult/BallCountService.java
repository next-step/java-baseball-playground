package gameResult;

import utils.ConstantUtils;

public class BallCountService {

    public int ballCount(int [] answer, int [] input) {

        int totalBall = 0;
        for(int answerIdx = 0; answerIdx < ConstantUtils.GAME_NUM_LENGTH; ++answerIdx){
            totalBall += countInputBallCompareAnswerElement(answer[answerIdx], input, answerIdx);
        }

        return totalBall;
    }

    int countInputBallCompareAnswerElement(int answer, int [] input, int answerIdx) {
        int ballByOneAnswerCount = 0;
        for(int inputIdx = 0; inputIdx < ConstantUtils.GAME_NUM_LENGTH; ++inputIdx){
            ballByOneAnswerCount += checkBall(answer, input[inputIdx], answerIdx, inputIdx);
        }

        return ballByOneAnswerCount;
    }

    int checkBall(int answerElement, int inputElement, int answerIdx, int inputIdx){
        if(answerElement == inputElement && answerIdx != inputIdx) return 1;
        return 0;
    }
}
