package study.StringCalculator;

public enum CALC_TYPE {

    OPERAND,
    OPERATOR,
    INVALID;

    static CALC_TYPE checkCalcType(String op) {
        if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))
            return CALC_TYPE.OPERATOR;

        try {
            int num = Integer.parseInt(op);
            return CALC_TYPE.OPERAND;
        } catch (NumberFormatException e) {
            return CALC_TYPE.INVALID;
        }
    }

}
