package study.StringCalculator;

import java.util.Arrays;

public enum OPERATOR_TYPE {

    PLUS("+")
    , MINUS("-")
    , MULTIPLY("*")
    , DIVIDE("/")
    ;

    String code;

    OPERATOR_TYPE(String code) {
        this.code = code;
    }

    static OPERATOR_TYPE getOpertorTypeByCode(String code) {
        return Arrays.stream(OPERATOR_TYPE.values())
                .filter(op -> op.code.equals(code)).
                findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
