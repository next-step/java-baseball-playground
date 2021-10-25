package baseball.domain;

import baseball.Application;

import java.util.List;
import java.util.Scanner;

public class Judgement {

    public int correctCount(List<Integer> computer, List<Integer> player) {

        int result = 0;

        for(int i = 0; i < player.size(); i++) {
            int playerNumber = player.get(i);
            if(computer.contains(playerNumber)) {
                result++;
            }
        }

        return result;
    }

    public Boolean hasPlace(List<Integer> computer, int placeIndex, int number) {

        return computer.get(placeIndex) == number;
    }

    public int getStrikeCount(List<Integer>computer, List<Integer> player) {

        int strike = 0;
        for (int placeIndex = 0; placeIndex < player.size(); placeIndex++) {
            if (hasPlace(computer, placeIndex, player.get(placeIndex))) {
                strike++;
            }
        }
        return strike;
    }
}
