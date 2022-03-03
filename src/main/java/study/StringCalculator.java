package study;

public class StringCalculator {

    //TODO 문자열을 배열로 나누는 메소드
    public String[] spaceSplit(String value) {
        if (value == null) {
            return new String[]{};
        }

        return value.split(" ");
    }


    //TODO 입력값 중 숫자와 부호를 구분하는 메소드

    //TODO 사칙연산 메소드
}
