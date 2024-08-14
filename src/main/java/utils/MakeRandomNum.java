package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeRandomNum {
    private List<Integer> numList;
    private static boolean[] check; // true이면 값이 들어가있다
    public MakeRandomNum() {
        check = new boolean[10]; // 1~9 사이의 수 파악
    }
    public List<Integer> makeRandomNum(){
        numList = new ArrayList<>();
        Random random = new Random();
        int idx = 0;
        while(idx != 3) {
            int num = random.nextInt(9)+1; // 1 ~ 4 까지의 무작위 int 값 리턴
            idx = checkDuplicate(idx, num);
        }
        return numList;
    }
    public int checkDuplicate(int idx, int num) {
        if(!check[num]) {
            idx++;
            check[num] = true;
            numList.add(num);
        }
        return idx;
    }
}
