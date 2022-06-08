package stringCalculator;

import java.util.LinkedList;
import java.util.Queue;

public class Operators {
    private final Queue<Operator> operators;

    public Operators(String[] split) {
        operators = new LinkedList<>();
        setOperators(split);
    }

    private void setOperators(String[] split) {
        for (int i = 1; i < split.length; i += 2) {
            operators.add(new Operator(split[i]));
        }
    }


    public Operator poll() {
        return operators.poll();
    }
}
