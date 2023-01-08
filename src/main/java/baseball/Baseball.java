package baseball;

import java.util.*;
import java.util.stream.IntStream;

public class Baseball {
    private static final int len = 3;

    public void play() {
        Scanner scanner = new Scanner(System.in);
        do {
            baseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (scanner.nextInt() != 2);
    }

    public void baseballGame() {
        List<String> user = input();
        List<String> computer = random();
        boolean result;
        do {
            int strikeCount = strike(computer, user);
            int ballCount = ball(computer, user);
            result = printResult(strikeCount, ballCount);

        } while(!result);
    }

    public boolean printResult(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            System.out.println("3 스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return false;
        }

        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        return false;
    }

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

        while (set.size() != 3) {
            int num = random.nextInt(9);
            set.add(Integer.toString(num));
            set.remove("0");
        }

        return new ArrayList<>(set);
    }

    public void duplicateCheck(List<String> numbers) {
        Set<String> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력해주세요.");
        }
    }

    public void lengthCheck(List<String> list) {
        if (list.size() != len) {
            throw new IllegalArgumentException(len + "자리 숫자를 입력해주세요.");
        }
    }

    public void zeroCheck(List<String> list) {
        if (list.contains("0")) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }

    public int strike(List<String> computer, List<String> user) {
        return (int) IntStream.range(0, len)
                .filter(i -> computer.get(i).equals(user.get(i)))
                .count();
    }

    public int ball(List<String> computer, List<String> user) {
        return (int) IntStream.range(0, len)
                .filter(i -> computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i)))
                .count();
    }
}
