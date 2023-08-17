package study;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringCalculator {

    public static void main(String[] args){
        String token = "";
        int amount = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("계산식 입력 : ");

        String inputData = sc.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(inputData, "+-*/");

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
