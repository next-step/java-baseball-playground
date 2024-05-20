package study.StringCalculator;


import static study.StringCalculator.OPERATOR_TYPE.getOpertorTypeByCode;
import static study.StringCalculator.Splitter.splitString;

class StringCalculatorImpl implements StringCalculator{

    @Override
    public int  calculator(String input) {
        String [] opArr = splitString(input);

        if(opArr.length % 2 == 0 ){
            throw new IllegalArgumentException("Invalid input");
        }

        if(CALC_TYPE.checkCalcType(opArr[0]) != CALC_TYPE.OPERAND) {
            throw new IllegalArgumentException("Invalid operand:" + opArr[0]);
        }

        int result = Integer.parseInt(opArr[0]);

        for(int i = 1; i < opArr.length; i += 2 ) {
            String operator = opArr[i];
            String operand = opArr[i+1];

            result = calculateEachElement(operator, operand, result);
        }

        return result;
    }

    private int calculateEachElement(String operator, String operand, int result) {

        CALC_TYPE operatorType = CALC_TYPE.checkCalcType(operator);
        CALC_TYPE operandType = CALC_TYPE.checkCalcType(operand);

        if(isOperator(operatorType)) {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        if(isOperand(operandType)) {
            throw new IllegalArgumentException("Invalid operand: " + operand);
        }

        OPERATOR_TYPE operatorCd =  getOpertorTypeByCode(operator);
        result = calculate(result, operatorCd, Integer.parseInt(operand));

        return result;
    }

    private int calculate(int result, OPERATOR_TYPE operator, int operand) {
        switch(operator) {
            case PLUS: return result + operand;
            case MINUS: return result - operand;
            case MULTIPLY: return result * operand;
            case DIVIDE: return result / operand;
        }
        throw new IllegalArgumentException("연산자는 더하기, 뺴기, 곱하기, 나누기만 가능합니다");
    }

    private boolean isOperator(CALC_TYPE type) {
        return type == CALC_TYPE.OPERATOR;
    }

    private boolean isOperand(CALC_TYPE type) {
        return type == CALC_TYPE.OPERAND;
    }
}
