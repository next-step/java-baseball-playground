package stringcal;

public class StringCalculator {

    public int add(int i, int j){
        return i+j;
    }

    public int subtract(int i, int j){
        return i-j;
    }

    public int multiply(int i, int j){
        return i*j;
    }

    public int divide(int i, int j){
        try{
            return i/j;
        }catch(Exception e){
            System.out.println("0으로 나눌수 없습니다.");
        }
        return 0;
    }

    //결과값이 null이거나 공백일 경우
    public static void notnull(Object k)throws IllegalAccessException{
        if(k == null || k == ""){
            throw new IllegalAccessException("공백이 있습니다.");
        }
    }

    //사칙연산 부분을 각각의 메서드로 나누기
    public int calculate(int firstvalue, char operator, int secondvalue){
        if(operator == '+')
            return add(firstvalue, secondvalue);
        if(operator == '-')
            return subtract(firstvalue, secondvalue);
        if(operator == '*')
            return multiply(firstvalue, secondvalue);
        if(operator == '/')
            return divide(firstvalue, secondvalue);
        else
            System.out.println("잘못된 값 입력");
        throw new RuntimeException();
    }
}