package study;

import java.util.*;

public class StringCalculator {

    private Deque<Integer> numberQueue;
    private Queue<String> signsQueue;
    private final Calculator calculator;

    public StringCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public Integer calculate(String[] targets) {
        this.parse(targets);
        while (this.numberQueue.size() > 1) {
            if(isEmptySign(this.signsQueue)) {
                break;
            }
            numberQueue.addFirst(calculator.calc(this.numberQueue.poll(), this.numberQueue.poll(), this.signsQueue.poll()));
        }

        return numberQueue.getFirst();
    }


    private void parse(String ...values) {
        this.numberQueue = new LinkedList<>();
        this.signsQueue = new LinkedList<>();
        for (String value :values) {
            try {
                numberQueue.add(Integer.parseInt(value));
            } catch (NumberFormatException numberFormatException) {
                signsQueue.add(value);
            }
        }
    }

    private boolean isEmptySign(Queue<String> signsQueue) {
        return signsQueue.isEmpty();
    }

}
