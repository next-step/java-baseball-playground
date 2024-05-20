package gameResult;

import utils.ConstantUtils;

public class StrikeCountService {

    public int countStrike(int[] answer, int[] input) {
        int strike = 0;
        for(int i = 0; i < ConstantUtils.GAME_NUM_LENGTH; ++i ) {
            strike += checkStrike(answer[i], input[i]);
        }

        return strike;
    }

    int checkStrike(int answerElement, int inputElement) {
        if(answerElement == inputElement) return 1;
        return 0;
    }
}
