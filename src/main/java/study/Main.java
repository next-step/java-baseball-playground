package study;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int firstValue = Integer.parseInt(values[0]);  // 배열의 처음 값.

        Calculator calculator = new Calculator(firstValue);

        for(int i = 0; i < values.length; i++){
            if(values[i].equals("+")){
                calculator.temp = calculator.add(calculator.temp, Integer.parseInt(values[i+1]));
            }
            if(values[i].equals("-")){
                calculator.temp = calculator.sub(calculator.temp, Integer.parseInt(values[i+1]));
            }
            if(values[i].equals("*")){
                calculator.temp = calculator.mul(calculator.temp, Integer.parseInt(values[i+1]));
            }
            if(values[i].equals("/")){
                calculator.temp = calculator.div(calculator.temp, Integer.parseInt(values[i+1]));
            }
        }

        System.out.println("Total : " + calculator.temp);
    }
}
