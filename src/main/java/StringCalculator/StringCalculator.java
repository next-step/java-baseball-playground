package StringCalculator;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    static String[] values;
    static int res = 0;

    public static void main(String[] args) {
        run();
        System.out.println(res);
    }

    public static void run(){
        input();
        res = operator();
    }

    public static void input(){
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        values = value.split(" ");
    }

    public static int operator(){
        int len = values.length;
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
        return res;
    }
}
