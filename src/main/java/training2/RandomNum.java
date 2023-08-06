package training2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNum {
    /*
    1~9 난수 생성
     */
    public int randomNumMake() {
        Random random = new Random();

        //n 미만의 랜덤 정수 리턴 (1~9)
        return random.nextInt(9) + 1;
    }

    /*
    3자리 중복되지 않는 난수 생성
     */
    public List<Integer> createRandomNum() {
        List<Integer> arrayList = new ArrayList<>();

        while (arrayList.size() < 3) {
            int num = randomNumMake();
            if (arrayList.contains(num)) {
                continue;
            }

            arrayList.add(num);
        }

        return arrayList;
    }
}
