import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean isValid(int num) { // 세자리 수가 맞는지 판단
        return num > 99 && num < 1000;
    }

    public static boolean isDuplicated(int num) { // 세자리 수 중 중복이 있는지 없는지 판단
        String strNum = Integer.toString(num);
        String[] splitStrNum = strNum.split("");
        List<String> list = new ArrayList<String>(Arrays.asList(splitStrNum));

        return list.size() != list.stream().distinct().count(); // 중복이 있으면 true 반환. 없으면 false 반환
    }
}
