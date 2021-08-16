package study;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Calculator calculator = new Calculator();

        calculator.setInputFormula();
        calculator.getOutputFormula();
    }
}

class Calculator{
    private String[] inputFormula;  // 입력 받는 수식을 저장하는 변수
    private int temp;               // 수식의 결과값을 저장하는 변수

    void setInputFormula(){ // 수식을 입력받는 메소드
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        inputFormula = value.split(" ");
    }

    void getOutputFormula (){ // 입력받은 수식을 연산하여 출력하는 메소드
        temp = Integer.parseInt(inputFormula[0]);

        for(int i = 0; i < inputFormula.length; i++){
            if(inputFormula[i].equals("+")){
                this.temp = this.add(this.temp, Integer.parseInt(inputFormula[i+1]));
            }
            if(inputFormula[i].equals("-")){
                this.temp = this.sub(this.temp, Integer.parseInt(inputFormula[i+1]));
            }
            if(inputFormula[i].equals("*")){
                this.temp = this.mul(this.temp, Integer.parseInt(inputFormula[i+1]));
            }
            if(inputFormula[i].equals("/")){
                this.temp = this.div(this.temp, Integer.parseInt(inputFormula[i+1]));
            }
        }

        System.out.println("연산결과 : " + temp);
    }

    // 사칙연산 메소드
    int add(int a, int b){  return a + b; }
    int sub(int a, int b){  return a - b; }
    int mul(int a, int b){  return a * b; }
    int div(int a, int b){  return a / b; }
}
