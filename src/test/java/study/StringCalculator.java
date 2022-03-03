package study;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final String regExp = "^[0-9]*$";
    private int result;
    private Operator currentOperator;

   public int calculateFormula(String[] formulaArray) {

       result = 0;
       currentOperator = Operator.PLUS;

       for(String input : formulaArray) {
           calculatePartial(input);
       }

       return result;
   }

   private void calculatePartial(String input) {

        if(Pattern.matches(regExp, input)) {
            result = currentOperator.operate(result, Integer.parseInt(input));
            return;
        }

        currentOperator = Operator.findOperator(input);

   }
}
