package baseball;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class CreateComputerBall {
    private HashSet<Integer> hashSet;

    public HashSet<Integer> getHashSet() {
        return hashSet;
    }

    void createCBall() {
        this.hashSet = new HashSet<>();
        Random ran = new Random();
        while (hashSet.size() < 3) {
            int number = ran.nextInt(9) + 1;
            hashSet.add(number);
        }


    }
}
