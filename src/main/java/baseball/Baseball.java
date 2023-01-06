package baseball;

import java.util.*;

public class Baseball {
    private static final int len = 3;
    public List<String> input() {
        Scanner scanner = new Scanner(System.in);
        List<String> input = List.of(scanner.nextLine().split(""));
        lengthCheck(input);
        duplicateCheck(input);
        zeroCheck(input);
        return input;
    }

    public List<String> random() {
        Random random = new Random();
        Set<String> set = new HashSet<>();

        while(set.size()!=3) {
            int num = random.nextInt(9);
            if(num == 0) {
                continue;
            }
            set.add(Integer.toString(num));
        }

        return new ArrayList<>(set);
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

    public void zeroCheck(List<String> list) {
        if(list.contains("0")) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }
}
