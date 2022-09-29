package baseball;

import java.util.Random;

public class GetRandom {

    public static int[] getRandoms(){
        int[] randoms = new int[3];
        randoms[0] = getRandom();

        randoms[2] = getRandom();

        do randoms[1] = getRandom();
        while (randoms[0] == randoms[1] || randoms[1] == randoms[2]);

        do randoms[2] = getRandom();
        while (randoms[0] == randoms[2] || randoms[1] == randoms[2]);

        //System.out.println(randoms[0] +" :: "+ randoms[1] + " :: " + randoms[2]);
        return randoms;
    }

    public static int getRandom(){
        Random ran = new Random();
        return ran.nextInt(10);
    }
}
