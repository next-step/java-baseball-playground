package study.stringCalculator;

public class Number {

    private int number;

    public Number() {
        this.number = 0;
    }

    private Number(String number) {
        this.number = Integer.parseInt(number);
    }

    public static Number from(String unitString) {
        return new Number(unitString);
    }

    public int toInt() {
        return number;
    }

    public void initResult(String initValue) {
        number = Integer.parseInt(initValue);
    }

    public void init() {
        this.number = 0;
    }

    public Number plus(Number second) {
        this.number += second.number;
        return this;
    }

    public Number minus(Number second) {
        this.number -= second.number;
        return this;
    }

    public Number multiply(Number second) {
        this.number *= second.number;
        return this;
    }

    public Number dividedBy(Number second) {
        if (second.isZero()) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        this.number /= second.number;
        return this;
    }

    private boolean isZero() {
        return this.number == 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.number == ((Number) obj).number;
    }
}
