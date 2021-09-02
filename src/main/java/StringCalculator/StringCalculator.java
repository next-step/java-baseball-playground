package StringCalculator;
import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        String[] values = value.split(" ");

        int len = values.length;
        int res = 0;
        String operand = "";
        for(int i = 0; i < len; i++){
            if(i == 0){
                res += parseInt(values[i]);
            }else if(i % 2 == 1){
                operand = values[i];
            }else if(i % 2 == 0){
                int num = Integer.parseInt(values[i]);
                switch(operand){
                    case "+": res += num;
                        break;
                    case "-": res -= num;
                        break;
                    case "*": res *= num;
                        break;
                    case "/": res /= num;
                        break;
                }
            }
        }
        System.out.println(res);
    }
}
