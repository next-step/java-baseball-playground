package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    // 1~9로 이뤄진 수
    // 같은 수가 같은 자리에 있으면 스트라이크
    // 다른 자리에 있으면 볼
    // 같은 수가 전혀 없으면 포볼 or 낫싱 힌트 제공

    List<Integer> intArr = new ArrayList<>();

    // 프로그램이 동작하면 3자리의 랜덤 수를 출력
    public void printRandomNumber() {
        int randomNum = (int) ((Math.random() * 10000) % 10);
        for (int i = 0; i < 3; i++) {
            intArr.add(randomNum);
        }
    }

}
