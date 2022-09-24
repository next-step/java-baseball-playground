package study.baseball;

import com.sun.tools.javac.code.Type;
import org.assertj.core.api.AbstractBooleanAssert;

import java.util.List;
import java.util.Objects;

public class ValidationUtils {

    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 1;
    public static boolean validNo(int no) {
        return no <= MAX_NUM && no >= MIN_NUM;

    }


}
