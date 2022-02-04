package study.mission01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 숫자 판별하는 핵심 로직
public class GameBoard {

    private int answer;
    private int theNumberOfDigits = 3;

    private String hint;

    public GameBoard() {
        // 랜덤 정답 생성기
        Random random = new Random();
        random.setSeed(100);
        answer = random.nextInt(999) + 1;
    }

    public String getHint(int guessNumber) {
        // answer 와 guessNumber 를 비교해야 한다.
        // 예: 713 vs 123
        // 우선 순위: 스트라이크인지 검사 -> 볼인지 검사 -> 낫싱인지 검사
        List<Integer> answers = convertNumberToArray(answer);
        List<Integer> guessNumbers = convertNumberToArray(guessNumber);
        // 이런 식으로 answer 의 백의 자리, 십의 자리, 일의 자리를 저장하고, guessNumber 의 자릿수와 비교를 한다.

        // for 문을 돌려서 3번 검사 했을 때 각각 맞아 떨어지면 count++을 한다. (스트라이크)
        int count = 0;
        List<Integer> position = new ArrayList<>(); // 0, 2
        // 스트라이크
        for (int i = 0; i < theNumberOfDigits; i++) {
            if (answers.get(i).equals(guessNumbers.get(i))) {
                count++;
                position.add(i);
            }
        }
        // 스트라이크가 됐으면 같은 자리에 일치하는 게 있다는 뜻이므로 스트라이크 값을 제거한다. 71 vs 12 (배열로 저장)
        for (Integer integer : position) {
            answers.remove(integer);
            guessNumbers.remove(integer);
        }
        // 71 과 12를 볼인지 비교를 한다. 이중 포문말고 map 에 answer 를 담는다. 밸류에 1씩 넣는다. map 의 키와 guessNumber 값을 비교해서 같은 수가 있는지 확인한다.
        // 같은 수가 있으면 키 값을 -1을 하고 (밸류 값이 0인지 확인은 안해도 되겠지? 같은 수가 중복 됐으면 스트라이크에서 걸렸을테니까) count++ 한다.(볼)
        // 스트라이크도 아니고 볼도 아니면 낫씽이다.

        return "로직 짜는 중";
    }

    private List<Integer> convertNumberToArray(int number) {
        List<Integer> numberComponents = new ArrayList<>();

        numberComponents.add(number / 100);
        numberComponents.add((number % 100) / 10);
        numberComponents.add(number % 10);

        return numberComponents;
    }

    public int getAnswer() {
        return this.answer;
    }
}
