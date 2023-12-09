package stringcalculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("식을 입력하세요 ex) 5*2-6+4");
        try {
            int result = Result.calculateResult();
            System.out.println("정답 : " + result);
        } catch (Exception e) {
            System.out.println("공백없이 숫자와 +, -, *, /만 작성해주세요");
            e.getMessage();
        }
    }
}
