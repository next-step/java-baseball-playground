package training1;

public class StringCalculator {
    public int getResult(String[] values){
        int result = Integer.parseInt(values[0]);

        for(int i=0; i<values.length-2; i+=2){
            int firstNum = result;
            String operation = values[i+1];
            int secondNum = Integer.parseInt(values[i+2]);
            result = calculate(firstNum, secondNum, operation);
        }

        return result;
    }

    public int calculate(int firstNum, int secondNum, String operation){
        int result = 0;

        if(operation.equals("+")){
            result = CalculatorUtil.add(firstNum,secondNum);
        } else if (operation.equals("-")) {
            result = CalculatorUtil.subtract(firstNum,secondNum);
        } else if (operation.equals("*")) {
            result = CalculatorUtil.multiple(firstNum,secondNum);
        } else if (operation.equals("/")) {
            result = CalculatorUtil.divide(firstNum,secondNum);
        }

        return result;
    }


}
