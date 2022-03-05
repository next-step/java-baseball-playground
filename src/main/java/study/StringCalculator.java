package study;

import study.enums.SignType;

import java.util.*;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    public String[] split(String value, String separator) {
        if (value == null) {
            return new String[]{};
        }

        return value.split(separator);
    }
    public Integer[] findNumerics(String[] values) {
        return Arrays.stream(values)
                .filter(value -> isNumerics(value))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
    }

    public String[] findSigns(String[] values) {
        List<String> result = new ArrayList<>();
        for (String value : values) {
            if(SignType.findSignType(value)) {
                result.add(value);
            }
        }
        return (String[]) result.toArray();
    }

    //사칙연산 메소드  + - / *
    public Integer add(int i, int j) {
        return i + j;
    }

    //사칙연산 메소드  -
    public Integer subtract(int i, int j) {
        return i - j;
    }
    public Integer multiply(int i, int j) {
        return i * j;
    }

    public Integer divide(int i, int j) {
        return i / j;
    }

    public Integer calucate(Integer[] numbers, String[] signs) {
        Deque<Integer> numberQueue = new LinkedList(Arrays.asList(numbers));
        Queue<String> signsQueue = new LinkedList(Arrays.asList(signs));

        while (signsQueue.size() > 0) {
            numberQueue.addFirst(operate(numberQueue.poll(), numberQueue.poll(), signsQueue.poll()));

        }
        return numberQueue.getFirst();
    }

    private Integer operate(int i, int j, String sign) {
        switch (sign) {
            case ADD:
                return add(i, j);
            case SUBTRACT:
                return subtract(i, j);
            case MULTIPLY:
                return multiply(i, j);
            case DIVIDE:
                return divide(i, j);
            default:
                return 0;
        }
    }

    private boolean isNumerics(String ...values) {
        try {
            for (String value : values) {
                Integer.parseInt(value);
            }
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }

}
