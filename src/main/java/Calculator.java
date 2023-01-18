import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BinaryOperator;

enum Sign{
    ADD("+",(v1,v2) -> v1+v2),
    SUBTRACT("-",(v1, v2) -> v1-v2),
    MULTIPLY("*",(v1, v2) -> v1*v2),
    DIVIDE("/",(v1, v2) -> v1/v2),
    EMPTY("없음",null);

    String type;
    private BinaryOperator<Integer> expression;
    Sign(String type, BinaryOperator<Integer> expression) {
        this.type = type;
        this.expression = expression;
    }

    public int calculate(int v1, int v2){
        return expression.apply(v1, v2);
    }

    public static Sign findByType(String str) {
        return Arrays.stream(Sign.values())
                .filter(sign -> sign.checkType(str))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean checkType(String str) {
        if(type.equals(str))
            return true;
        return false;
    }
}

public class Calculator {
    String[] expression;
    int[] numArray;
    int result;

    void inputData() {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        expression = value.split(" ");
    }

    void setArray(String expression) {
        this.expression = expression.split(" ");
        result = Integer.parseInt(this.expression[0]);
    }

    int calcNum() {
        int index = 0;
        int calcCount = expression.length / 2;
        for(int i = 0 ; i<calcCount ; i++){
            Sign sign = selectType(expression[index+1]);
            result = sign.calculate(result , Integer.parseInt(expression[index+2]));
            index += 2;
        }
        return result;
    }

    Sign selectType(String input) {
        return Sign.findByType(input);
    }

}
