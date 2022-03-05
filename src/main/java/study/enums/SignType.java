package study.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SignType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String sign;

    public static boolean findSignType(String target) {
        return Arrays.stream(values())
                .filter(value -> value.getSign().equals(target))
                .findFirst()
                .isPresent();
    }

}
