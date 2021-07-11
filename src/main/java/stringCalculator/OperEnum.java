package stringCalculator;

import java.util.Arrays;
import java.util.Optional;


public enum OperEnum {
    PLUS("+", (x,y) -> x + y),
    MINUS("-", (x,y) -> x - y),
    MULTIPLE("*", (x,y) -> x * y),
    DIVIDE("/", (x,y) -> {
        if ( y == 0) {
            throw new IllegalArgumentException("Divide by Zero");
        }
        return x/y;});

    String symbol;
    //lambda 자체가 함수임.
    Operation operation;

    OperEnum(String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }
    //명령 질의 delimiter ; ENUM조회만 하고, 메서드 적용은 별도
    //Operation은 int인자 2개 받고, 로직은 string 기준으로 구현됨
    //static 함수 선언 언제하는지, 이펙티브자바 & 멘토 기준 정리하기

    //java.util.Optional.orElseThrow(Optional.java:290) Optional<OperEnum> 정의 필요
    public static OperEnum of(String value) {
        Optional<OperEnum> maybeOperEnum =Arrays.stream(values())
                //An OperEnum => it's Symbol Equals Param operator
                            .filter(o -> o.symbol.equals(value))
                            .findFirst();
        return maybeOperEnum.orElseThrow(IllegalArgumentException::new);
    }

    //여기서 Operations함수가 아닌, int 반환
    //각 Operations가 어떻게 operate 처리할 것인지는 각 클래스에서 정의
    public int operate(int first, int second) {
        return operation.operate(first, second);
    }


}
