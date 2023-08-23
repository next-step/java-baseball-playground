package study;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringCalculator {

    /** 에러 1 .  계산식이 토큰으로 뽑히지 않음
     *  해결   .  StringTokenizer stringTokenizer = new StringTokenizer() 3번째 인자에 true 추가
     *           3번째 인자는 구분자로 토큰을 분리할 때 구분자도 토큰에 포함시킬지 여부 default값은 false
     * **/

    public static void main(String[] args){
        String token = "";
        int amount = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("계산식 입력 : ");

        String inputData = sc.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(inputData, "+-*/", true);

        try {
            while (stringTokenizer.hasMoreTokens()){

                token = stringTokenizer.nextToken();

                if (token.equals("+")){

                    token = stringTokenizer.nextToken();
                    amount += Integer.parseInt(token);


                } else if (token.equals("-")) {

                    token = stringTokenizer.nextToken();
                    amount -= Integer.parseInt(token);

                } else if (token.equals("*")) {

                    token = stringTokenizer.nextToken();
                    amount *= Integer.parseInt(token);

                } else if (token.equals("/")) {

                    token = stringTokenizer.nextToken();
                    amount /= Integer.parseInt(token);

                } else {
                    amount = Integer.parseInt(token);
                }

            }
            System.out.println("결과값 : " + amount);

        } catch (NullPointerException e){

        }


    }

    public String _StringCalculator() {

        Scanner scanner = new Scanner(System.in);

        String scanInput = scanner.nextLine();


        return null;
    }
}
