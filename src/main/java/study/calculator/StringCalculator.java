package study.calculator;

import study.calculator.Calculator;

import java.util.*;

public class StringCalculator {

    private final Deque<Integer> numberQueue;
    private final Deque<String> signsQueue;
    private final Calculator calculator;
    private final String calculatedValue;

    public StringCalculator(Calculator calculator, String calculatedValue) {
        this.numberQueue = new LinkedList<>();
        this.signsQueue = new LinkedList<>();
        this.calculator = calculator;
        this.calculatedValue = calculatedValue;
    }

    public Integer calculate() throws NullPointerException {
        this.parse(calculatedValue);
        while (this.numberQueue.size() > 1) {
            if(isEmptySignStack()) break;
            numberQueue.addFirst(calculator.calc(this.numberQueue.poll(), this.numberQueue.poll(), this.signsQueue.poll()));
        }

        return numberQueue.getFirst();
    }

    private void parse(String values) {
        for (String value :values.split(" ")) {
            parseAndPush(value);
        }
    }

    private void parseAndPush(String value) {
        try {
            numberQueue.add(Integer.parseInt(value));
        } catch (NumberFormatException numberFormatException) {
            signsQueue.add(value);
        }
    }

    private boolean isEmptySignStack() {
        return this.signsQueue.isEmpty();
    }


}
