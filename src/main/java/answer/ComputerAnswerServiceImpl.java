package answer;

import answer.check.CheckUseAnswer;

import static answer.random.RandomNumber.generateRandomNumber;
import static utils.ConstantUtils.GAME_NUM_LENGTH;

public class ComputerAnswerServiceImpl implements ComputerAnswerService {


    @Override
    public int[] makeAnswer() {
        CheckUseAnswer checkUseAnswerArr = new CheckUseAnswer();
        int [] answer = new int[GAME_NUM_LENGTH];

        for(int i = 0; i < GAME_NUM_LENGTH; ++i ){
            int answerNum = generateUniqueRandomNumber(checkUseAnswerArr);
            answer[i] = answerNum;
            checkUseAnswerArr.checkAnswer(answer[i]);
        }
        return answer;
    }

    int generateUniqueRandomNumber(CheckUseAnswer checkUseAnswerArr) {
        int randomNum = 0;
        while (!checkUseAnswerArr.isNotCheckedAnswer(randomNum)) {
            randomNum = generateRandomNumber();
        }
        return randomNum;
    }
}
