package domain;

import java.util.List;

public class judgment {
    public int correctCount(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (int i = 0; i < player.size(); i++) {
            int playerNumber = player.get(i);
            if (computer.contains(playerNumber)) {
                result++;
            }
        }
        return 0;
    }

    public boolean hasPlace(int placeNumber, int number) {
        return true;
    }
}
