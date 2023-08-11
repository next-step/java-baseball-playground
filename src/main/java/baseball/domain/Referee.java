package baseball.domain;

import java.util.List;

public class Referee {
    public GameStatus compare(List<GameNumber> computer, List<GameNumber> user) {
        final Judgement judgement = new Judgement();
        int correctCount = judgement.correctCount(computer, user);

        int strike = 0;
        for (int i = 0 ; i < computer.size(); i++) {
            if(judgement.hasPlace(computer, i, user.get(i).getNumber())) {
                strike++;
            }
        }
        int ball = correctCount-strike;

        return new GameStatus(strike, ball);
    }

}
