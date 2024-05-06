package com.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballFactory {
    private static final char Zero_Char = '0';
    private static final int Valid_Baseball_Size = 3;
    private static final int Random_Number_Origin = 1;
    private static final int Random_Number_Bound = 10;

    private static Baseball createBaseball(int number){
        return new Baseball(number);
    }

    public static Baseballs createBaseballs(String baseballNumbers){
        List<Baseball> baseballs = new ArrayList<>();

        for (int i = 0; i<baseballNumbers.length(); i++){
            baseballs.add(createBaseball(baseballNumbers.charAt(i) - Zero_Char));
        }
        return new Baseballs(baseballs);
    }


    public static Baseballs createRandomBaseballs() {
        List<Baseball> baseballs = new ArrayList<>();
        Random random = new Random();

        while (baseballs.size() < Valid_Baseball_Size) {
            int randomNumber = random.nextInt(Random_Number_Bound - Random_Number_Origin) + Random_Number_Origin;
            Baseball baseball = createBaseball(randomNumber);
            if (!baseballs.contains(baseball)) {
                baseballs.add(baseball);
            }
        }

        return new Baseballs(baseballs);
    }

}
