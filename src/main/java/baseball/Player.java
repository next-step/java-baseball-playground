package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static List<Integer> list = new ArrayList<>();

    public Player(String input) {
        for (char ch : input.trim().toCharArray()) {
            setPlayerNumber(ch);
        }
        if (!Validation.confirmDuplication(getList())) {
            System.out.println("배열안에 중복값이 있습니다. 다시 입력해 주세요");
            new Player(InputView.input());
            return;
        }
        if(!Validation.confirmSize(getList())) {
            System.out.println("3개의 숫자를 입력해 주세요");
            new Player(InputView.input());
            return;
        }
    }

    private void setPlayerNumber(char ch) {
        if (!Validation.confirmNumber(ch - 48)) {
            System.out.println("1~9 사이의 숫자를 입력해 주세요");
            new Player(InputView.input());
            return;
        }
        // 0~9 숫자가 아닙니다 출력 후 되돌아가기
        list.add(ch - 48);
        return;
    }

    public List<Integer> getList() {
        return list;
    }

}
