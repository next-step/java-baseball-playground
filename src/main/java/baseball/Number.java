package baseball;

public class Number {
    private final int number;

    public Number(int number){
        if (!ValidationCheck.isCorrect(number))
            throw new IllegalArgumentException("1에서9까지의 숫자가 아닙니다.");

        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
