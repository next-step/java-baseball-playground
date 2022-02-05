package study.mission01;

import java.util.LinkedHashMap;
import java.util.Map;

public class Referee {

    private Map<Integer, Integer> answerMap;
    private Map<Integer, Integer> guessNumberMap;
    private Map<String, String> hint = new LinkedHashMap<>();   // 순서가 중요
    private String result;
    private int strike = 0;
    private int ball = 0;

    public Referee(int answer, int guessNumber) {
        answerMap = NumberGenerator.disassembleNumber(answer);
        guessNumberMap = NumberGenerator.disassembleNumber(guessNumber);
    }

    // 핵심 로직 (입력된 숫자가 스트라이크인지 볼인지 nothing 인지 판단하고 결과 반환)
    public String check() {

        for (int i = 100; i > 0; i /= 10) {
            boolean isStrikeOrBall = answerMap.containsValue(guessNumberMap.get(i));
            boolean isStrike = answerMap.get(i).equals(guessNumberMap.get(i));

            if (isStrikeOrBall) {
                if (isStrike) {
                    strike++;
                    hint.put("strike", String.valueOf(strike));
                    continue;
                }
                ball++;
                hint.put("ball", String.valueOf(ball));
            }
        }

        result = processHintData();

        return result;
    }

    // result 를 문자열로 변환하는 작업을 한다.
    private String processHintData() {
        StringBuilder sb = new StringBuilder();
        if (hint.size() > 1) {
            for (Map.Entry<String, String> entry : hint.entrySet()) {
                sb.append(entry.getValue()).append(entry.getKey()).append(" ");
            }
            result = String.valueOf(sb);
        } else if (hint.size() == 1) {
            for (Map.Entry<String, String> entry : hint.entrySet()) {
                sb.append(entry.getValue()).append(entry.getKey());
            }
            result = String.valueOf(sb);
        } else {
            result = "nothing";
        }

        return result;
    }

}
