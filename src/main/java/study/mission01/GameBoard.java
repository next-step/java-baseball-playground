package study.mission01;

import java.util.*;

// 숫자 판별하는 핵심 로직
public class GameBoard {

    private int answer;
    private final int theNumberOfDigits = 3;



    private String hint;

    public GameBoard() {
        // 랜덤 정답 생성기
        Random random = new Random();
        random.setSeed(100);
        answer = random.nextInt(999) + 1;
    }

    // 힌트를 생성하는 메소드
    public Map<String, Integer> getHint(int guessNumber) {
        Map<Integer, Integer> answerMap = convertNumberToArray(answer);
        Map<Integer, Integer> guessNumberMap = convertNumberToArray(guessNumber);

        Map<String, Integer> hint = new LinkedHashMap<>();
        int strike = 0;
        int ball = 0;

        for (int i = 100; i > 0; i/=10) {
            // 스트라이크, 볼 판단 기준: input number
            boolean containsValue = answerMap.containsValue(guessNumberMap.get(i));
            boolean valueIsEquals = answerMap.get(i).equals(guessNumberMap.get(i));

            if (containsValue) {
                if (valueIsEquals) {
                    strike++;
                    System.out.println("strike = " + strike);
                    hint.put("strike", strike);
                    continue;
                }
                ball++;
                System.out.println("ball = " + ball);
                hint.put("ball", ball);
            }
        } // for
        // 낫띵은..?


        return hint;
    }

    private Map<Integer, Integer> convertNumberToArray(int number) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(100, number / 100);
        map.put(10, (number % 100) / 10);
        map.put(1, number % 10);

        return map;
    }

    public int getAnswer() {
        return this.answer;
    }
}
