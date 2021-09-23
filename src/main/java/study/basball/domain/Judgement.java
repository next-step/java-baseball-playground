package study.basball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Judgement {

    public List<Boolean> currectCount(HashSet<Integer> computer, List<Integer> player) {
        List<Boolean> currectMatch = new ArrayList<>();
        Iterator<Integer> iter = computer.iterator();
        while (iter.hasNext()) {
            for (Integer number : player) {
                if (iter.next() == number) {
                    currectMatch.add(true);
                }
            }
        }
        return currectMatch;
    }

    public List<Boolean> hasPlace(HashSet<Integer> computer, List<Integer> player) {
        List<Boolean> containNumbers = new ArrayList<>();

        for (Integer number : player) {
            if (computer.contains(number)) {
                containNumbers.add(true);
            }
        }
        return containNumbers;
    }

}
