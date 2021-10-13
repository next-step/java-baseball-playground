package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Balls {
    private static final int MAX_RANGE = 9;
    private static final int MIN_RANGE = 1;
    private List<Ball> balls = new ArrayList<>();

    public Balls(String input){
        List<Integer> numberList = changeToIntegers(input);
        if(validateNumbers(numberList)){
            numberList.forEach((s)->balls.add(new Ball(numberList.indexOf(s),s)));
        }
    }
    public Balls(List<Integer> numberList){
        if(validateNumbers(numberList)){
            numberList.forEach((s)->balls.add(new Ball(numberList.indexOf(s),s)));
        }
    }

    private List<Integer> changeToIntegers(String input){
        String[] numbers = input.split("");
        List<Integer> list =  Arrays.stream(numbers).map(s->Integer.parseInt(s)).collect(Collectors.toList());
        return list;
    }

    public static boolean validateNumbers(List<Integer> numberList) {
        boolean overlapStatus = isOverlaped(numberList);
        boolean overRangeStatus = isOverrange(numberList);

        if(overlapStatus){
            throw new RuntimeException("중복값이 발생했습니다.");
        }
        if(overRangeStatus){
            throw new RuntimeException("1~9 사이의 숫자가 아닙니다.");
        }
        return true;
    }

    private static boolean isOverlaped(List<Integer> numberList) {
        int length = (int) numberList.stream().distinct().count();
        return !(length == 3);
    }

    private static boolean isOverrange(List<Integer> numberList) {
        return numberList.stream().anyMatch(s -> (s>MAX_RANGE || s<MIN_RANGE));
    }

    public List<Ball> getBalls() {
        return this.balls;
    }
}
