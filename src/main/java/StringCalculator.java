import java.util.Scanner;
public class StringCalculator {

    public static String[] ValueToArray(String input){
        String[] SplitedValues = input.split(" ");
        return SplitedValues;
    }

    public static int CalculatebyValue(String[] arraydata) {
        int result = Integer.parseInt(arraydata[0]);
        for (int i=0; i < arraydata.length -2 ; i += 2) {
            System.out.printf("result : %d\n", result);
            result = Calc(arraydata[i + 1], result, Integer.parseInt(arraydata[i + 2]));
        }
        return result;
    }

    public static int add(int param1, int param2){
        return param1 + param2;
    }

    public static int sub(int param1, int param2){
        return param1 - param2;
    }

    public static int div(int param1, int param2){
        try {
            return param1 / param2;
        } catch (Exception e) {
            throw new ArithmeticException("0은 나눌 수 없습니다.");
        }
    }

    public static int mul(int param1, int param2){
        return param1 * param2;
    }

    public static int Calc(String operator, int param1, int param2){
        switch (operator){
            case "+" :
                return add(param1, param2);
            case "-" :
                return sub(param1, param2);
            case "*":
                return mul(param1, param2);
            case "/":
                return div(param1, param2);
        }
//        System.out.printf("%d, %s %d", param1, operator, param2);
        throw new IllegalArgumentException("연산자 자리에 확인되지 않은 문자가 들어왔습니다. 연산자 : " + operator);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("수식을 입력 하세요");
        System.out.print("> ");
        String CalValue = scanner.nextLine();

        String[] val = ValueToArray(CalValue);
        System.out.println(CalculatebyValue(val));
        }
    }


