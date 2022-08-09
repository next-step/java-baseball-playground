package study.calculator;


import java.awt.*;
import java.io.IOException;

public final class Calculator {
    private int result =0;
   private String operation;

   private Calculator(){}
   private Calculator(String target){
       try{
           result = calculator(target);
       }catch (Exception e){
           e.printStackTrace();
           throw new IllegalArgumentException();
       }
   }

   //생성자 숨김을 위한 정적 팩터리 메서드 구현
   public static Calculator isCalculaor(String target) throws Exception{
       return  new Calculator(target) ;
   }

   // 계산된 결과 값을 가져와야하니깐 getter 메서드 추가.(공개되어야하는 값이 있는 경우)
   public int getResult(){
       return this.result;
   }

    // 문자열로 들어온 계산식을 구분해서 순서대로(일반적인 계산방법이 아닌 배열에서 꺼낸 순서로 제공한다.) 계산해주는 메서드
    // 1. 문자열을 계산식과 숫자로 잘라서 두개의 배열로 만든다.
    // 2. 숫자 배열의 첫번째 값을 result에 담는다.
    // 3. for문에서 다음에 나올 숫자를 second에 담고
    // 4. operation에 있는 값을 한개꺼내서 계산기에 보낸다.
    private final int calculator(String target) throws Exception{

        String[] targets = target.split(" ");
        vallidation(targets);
        result = Integer.parseInt(targets[0]);
        int second = 0;

        for(int i = 1; i < targets.length; i++){
            if(targets[i].matches("[+\\-*/]")){
                operation = targets[i];
                continue;
            }

            second = Integer.parseInt(targets[i]);
            result = calculate(operation, result , second);
        }

        return result;
    }

    private final void vallidation(String[] targets){
        int len = targets.length;

        for (int target = 0; target < len; target++){
            if (targets[target].length() > 1
                    ||  targets[0].matches("[+\\-*/]")
                    || targets[len-1].matches("[+\\-*/]")){
                throw new IllegalArgumentException();
            }
        }
    }

    private final int calculate(String deli, int first,int second) throws Exception{

        if(deli.equals("+")){
            return first + second;
        }
        if(deli.equals("-")){
            return first - second;
        }
        if(deli.equals("*")){
            return first * second;
        }
        if(deli.equals("/")){
            return first / second;
        }

        throw new IllegalArgumentException();
    }


}