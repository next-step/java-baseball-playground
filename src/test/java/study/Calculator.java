package study;



public class Calculator {
    int result;
    String operation;

    // 문자열로 들어온 계산식을 구분해서 순서대로(일반적인 계산방법이 아닌 배열에서 꺼낸 순서로 제공한다.) 계산해주는 메서드
    // 1. 문자열을 계산식과 숫자로 잘라서 두개의 배열로 만든다.
    // 2. 숫자 배열의 첫번째 값을 result에 담는다.
    // 3. for문에서 다음에 나올 숫자를 second에 담고
    // 4. operation에 있는 값을 한개꺼내서 계산기에 보낸다.
    public int calculator(String target) throws Exception{

        String[] targets = target.split(" ");
        result = Integer.parseInt(targets[0]);
        int second =0;


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

    private int calculate(String deli, int first,int second) throws Exception{

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
