package baseboll.myTrial.allInOne;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class BadCaseGame {
    private final BufferedReader br;
    public BadCaseGame(BufferedReader br) {
        this.br = br;
    }
    public void game() throws IOException {
        String answer = String.valueOf(makeRandomAnswer());
        progressGame(answer);
    }
    private void progressGame(String answer) throws IOException {
        String input = getInput(); // 사용자에게 입력값 받아오기
        if (!isPossible(input)) progressGame(answer);
        if (isCorrect(input, answer)) {
            continueOrNot();
            return;
        }
        countTotal(input, answer);
        progressGame(answer);
    }

    private boolean isPossible(String input) {
        return false;
    }

    private void countTotal(String input, String answer){
        int strikeCount = strikeCountChecker(input, answer);
        int ballCount = ballCountChecker(input, answer);
        StringBuilder sb = new StringBuilder();
        if (strikeCount == 0 & ballCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikeCount != 0) sb.append(strikeCount).append("스트라이크");
        if (ballCount != 0) sb.append(ballCount).append("볼");
        System.out.println(sb.toString());
    }

    private int makeRandomAnswer() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits);
        int firstDigit = digits.get(0);
        int secondDigit = digits.get(1);
        int thirdDigit = digits.get(2);
        return firstDigit * 100 + secondDigit * 10 + thirdDigit;
    }

    private String getInput() throws IOException {
        System.out.println("숫자를 입력 해 주세요");
        return br.readLine();
    }

    private void continueOrNot() throws IOException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = br.readLine();
        if (input.equals("1")) {
            game();
            return;
        }
        if (input.equals("2")) {
            return;
        }
        System.out.println("잘못된 입력입니다.");
    }

    private int strikeCountChecker(String input, String answer){
        String[] given = input.split("");
        String[] ans = answer.split("");
        int correctCount = 0;
        for (int i = 0; i < given.length; i++) {
            correctCount += strikeCheck(given[i], ans[i]);
        }
        return correctCount;
    }

    private int ballCountChecker(String input, String answer){
        String[] given = input.split("");
        Set<String> set = new HashSet<>(Arrays.asList(given));
        int count = 0;
        for (String s : set) {
            count += ballCheck(s, answer);
        }
        int alreadyCountedStrike = strikeCountChecker(input, answer);
        if (alreadyCountedStrike != 0) count -= alreadyCountedStrike;
        return count;
    }

    private int strikeCheck(String s, String d){
        return s.equals(d) ? 1 : 0;
    }

    private int ballCheck(String input, String answer){
        return answer.contains(input) ? 1 : 0;
    }

    private boolean isCorrect(String input, String answer){
        return input.equals(answer);
    }
}
