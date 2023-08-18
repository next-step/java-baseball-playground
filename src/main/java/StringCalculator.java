public class StringCalculator {
    public String[] toStringArray(String s){
        return s.split(" ");
    }

    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b){
        if (b == 0) throw new IllegalArgumentException("0으로 나눌 수 없다 인마");
        return a / b;
    }

    public int calculate(int a, int b, String operator){
        if (operator.equals("+")) return add(a, b);
        if (operator.equals("-")) return subtract(a,b);
        if (operator.equals("*")) return multiply(a,b);
        if (operator.equals("/")) return divide(a,b);

        throw new IllegalArgumentException("잘못된 입력이다 인마");
    }

    public int calculateString(String s){
        String[] stringArray = toStringArray(s);
        int answer = Integer.parseInt(stringArray[0]);
        for (int i = 1; i < stringArray.length; i += 2) {
            answer = calculate(answer, Integer.parseInt(stringArray[i + 1]), stringArray[i]);
        }
        return answer;
    }
}
