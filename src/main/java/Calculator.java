public class Calculator {

    int result = 0;
    // 이 클래스의 calculate 메서드를 사용하면 문자열로 입력된 것이 계산된다.
    // 우선 문자열을 분할 해주는 메서드
    // 안에서 무슨일이 벌어지든 상관 없다. 계산만 제대로 해서 주면된다.
    // 띄여쓰기 단위로 분할하는 것

    public String[] splitString(String arr){
        return arr.split("\\s");
    }

    //문자열을 구분해서 계산해주는 메서드
    public int calculator(String[] target){

        result = Integer.parseInt(target[0]);

        for(String a : target){

            if ( a == target[0] ) {
                continue;
            }

        }

        // 분기 태우기
        return result;
    }

    public void calculate(String[] target){

    }


}
