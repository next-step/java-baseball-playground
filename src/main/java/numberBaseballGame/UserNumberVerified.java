package numberBaseballGame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserNumberVerified {
    private List<Integer> userNumberList;

    public UserNumberVerified(String userNumber) {
        if(digitCheck(userNumber) && charCheck(userNumber) && overlapCheck(userNumber)) {
            int[] digits = Stream.of(userNumber.split("")).mapToInt(Integer::parseInt).toArray();
            userNumberList = Arrays.stream(digits).boxed().collect(Collectors.toList());
        }
    }

    public List<Integer> getUserNumberList() {
        return userNumberList;
    }

    private boolean overlapCheck(String userNumber) {
        Set<String> stringSet = new HashSet<>();

        for(int i = 0; i < userNumber.length(); i++) {
            stringSet.add(String.valueOf(userNumber.charAt(i)));
        }

        if(stringSet.size() != userNumber.length()) {
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
        }

        return true;
    }

    private boolean charCheck(String userNumber) {
        try {
            Integer.parseInt(userNumber);
        }

        catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌것을 입력했습니다.");
        }

        return true;
    }

    public boolean digitCheck(String input) {
        if(input.contains(" "))
            throw new IllegalArgumentException("띄어쓰기 없이 입력해주세요.");

        if(input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        return true;
    }
}
