package study.mission01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberGenerator {


    public static int generate() {
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int number = 0;

        while (set.size() < 3) {
            number = (int) (Math.random() * 9) + 1;
            set.add(number);
        }

        for (Integer integer : set) {
            sb.append(integer);
        }

        number = Integer.parseInt(String.valueOf(sb));
        System.out.println("NumberGenerator.generate - number = " + number);
        return number;
    }

    public static Map<Integer, Integer> disassembleNumber(int number) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(100, number / 100);
        map.put(10, (number % 100) / 10);
        map.put(1, number % 10);

        return map;
    }
}
