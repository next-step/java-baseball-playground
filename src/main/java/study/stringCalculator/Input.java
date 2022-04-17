package study.stringCalculator;

public class Input {
    String str;

    public Input() {
        this.str = "";
    }

    public String[] split(String splittedBy) {
        return str.split(splittedBy);
    }

    public void init() {
        this.str = "";
    }

    public void update(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) throw new IllegalArgumentException("input must have length over 0");
        this.str = s;
    }
}
