package NumberBaseballGame;

import java.util.List;

public class NumberChecker {
    private int strikeCount;
    private int ballCount;

    public NumberChecker() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void checkNumber(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for(int i = 0; i < userNumbers.size(); i++) {
            for(int j = 0; j < computerNumbers.size(); j++) {
                if(userNumbers.get(i) == computerNumbers.get(j)) {
                    if(i == j) {
                        strikeCount++;
                        break;
                    }
                    ballCount++;
                    break;
                }
            }
        }
    }

    public int getStrikeCount() { return strikeCount; }

    public int getBallCount() { return strikeCount; }
}
