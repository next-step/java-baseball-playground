package string_calculator;

import java.security.InvalidParameterException;

public enum Operation {
    ADD("+"), SUB("-"), MUL("*"), DIV("/");

    public String oper;

    Operation(String operation) {
        this.oper = operation;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        return a / b;
    }
}
