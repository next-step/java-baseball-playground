package baseball;

import java.util.*;

public class Baseball {
    private static final int len = 3;
    public List<String> input() {
        Scanner scanner = new Scanner(System.in);
        List<String> input = List.of(scanner.nextLine().split(""));
        lengthCheck(input);
        duplicateCheck(input);
        return input;
    }

    public List<String> random() {
        Random random = new Random();
        return null;
    }

    public void duplicateCheck(List<String> numbers) {
        Set<String> set = new HashSet<>();
        for (String number : numbers) {
            set.add(number);
        }
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력해주세요.");
        }
    }

    public void lengthCheck(List<String> list) {
        if(list.size() != len) {
            throw new IllegalArgumentException(len+"자리 숫자를 입력해주세요.");
        }
    }
}
