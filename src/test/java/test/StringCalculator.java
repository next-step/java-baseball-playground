package test;// @ author ninaaano

import java.util.Scanner;

/**
 * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 *
 * 문자열을 입력 받은 후(scanner의 nextLine() 메소드 활용) 빈 공백 문자열을 기준으로 문자들을 분리해야 한다.
 */

public class StringCalculator {


    // 사용자의 입력을 받아 String 으로 반환한다
    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    // 입력받은 String을 공백 기준으로 나눠 String배열에 저장해준다
    public String[] separate(String value) {
        return value.split(" ");
    }

    /**
     * 결과적으로 배열안에는 "1","+","2".. 이런식으로 들어가있을 것이다.
     * 여기서 따로 추출하는 과정을 거쳐야한다
     * @param str
     * @return
     */

    // String이 들어오면 number만 뽑아서 준다
    public int stringConverter(String str){
        String restr = str.replaceAll("[^0-9]","");
        return Integer.parseInt(restr);
    }

    public int calculator(int number,String operator,int second) throws Exception{
        if(operator == "+") {
            return add(number,second);
        }
        if(operator == "-") {
            return subtract(number,second);
        }
        if (operator == "*") {
            return multiply(number,second);
        }
        if (operator == "/") {
            return divide(number, second);
        }
        throw new Exception("잘못된 값을 입력했습니다.");
    }




    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    public int multiply(int i, int j) {
        return i * j;
    }

    public int divide(int i, int j) {
        if(j == 0){
            System.out.println("0으로 나눌 수 없습니다");
            return 0;
        }
        return i/j;
    }

}

