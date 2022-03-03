package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern regExp = Pattern.compile("^[0-9]*$");

   public int calculateFormula(String[] formulaArray) {

       int result = 0;
       Operator currentOperator = Operator.PLUS;

       for(String input : formulaArray) {
           if(regExp.matcher(input).find()) {
               result = currentOperator.operate(result, Integer.parseInt(input));
               continue;
           }
           currentOperator = Operator.findOperator(input);
       }

       return result;
   }
}
