package training2;

import java.util.List;

public class NumCompare {
    public int countStrike(List<Integer> numList, List<Integer> checkNum) {
        int count = 0;
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) == checkNum.get(i)) {
                count++;
            }
        }

        return count;
    }

    public int countBall(List<Integer> numList, List<Integer> checkNum) {
        int count = 0;
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) != checkNum.get(i) && numList.contains(checkNum.get(i))) {
                count++;
            }
        }

        return count;
    }


}
