package stringCalculator;

import java.util.ArrayList;
import java.util.List;

//ArrayIndexOutOfBoundsException :: include Operations.class
//OperEnum construct
// new Class() != Class::new
public class StringCalc {
    private static List<YesOperation> operations = new ArrayList<>();
    static {
        operations.add(new Addition());
        operations.add(new Subtraction());
        operations.add(new Multiplication());
        operations.add(new Division());

    }
//trim(), null check first then "||" : to throw IllegalArg instead of NullPointerException
    public static int calculate(String value) {
//            throws IllegalArgumentException {
//        if (value == null || value.trim().isEmpty()) {
//             throw new IllegalArgumentException();
//        }
        // java .length

        String[] values = value.split(" ");
        int output = Integer.parseInt(values[0]);
        //first i=0 initial, then starts i=1
        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];
            //next val is right next to Operator
            int next = Integer.parseInt(values[i + 1]);
            output = calculate(output, next, operator);
        }
        return output;
    }

    //override overload "calculate"
    private static int calculate(int first, int second, String operator) {
            int result = OperEnum.of(operator).operate(first, second);
        return result;
    }
}
