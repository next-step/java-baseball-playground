package Baseball;

import java.util.*;

public class BallNumberMaker {
    private List<Integer> ballNumbers;

    public void makeBallNumbers() {
        Random random = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        while(set.size() < 3) {
            set.add(random.nextInt(9) + 1);
        }
        ballNumbers = new ArrayList<>(set);
    }

    public void makeBallNumbers(String ballNumbers) {
        this.ballNumbers = new ArrayList<>();
        for(int i = 0; i < ballNumbers.length(); i++) {
            this.ballNumbers.add(Integer.valueOf(String.valueOf(ballNumbers.charAt(i))));
        }
    }

    public List<Integer> getBallNumbers() {
        return ballNumbers;
    }
}
