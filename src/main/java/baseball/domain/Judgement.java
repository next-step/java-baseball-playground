package baseball.domain;

import java.util.List;

public class Judgement {
    public int correctCount(List<GameNumber> computer, List<GameNumber> user) {
        int result = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i))) {
                result++;
            }
        }
        return result;
    }

    public boolean hasPlace(List<GameNumber> computer, int index, int number) {
        return computer.get(index).equals(new GameNumber(number));
    }

}
