package baseball;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class BaseBallMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Stream.of(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
    }
}
