package BaseBall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public List<Integer> input() throws IOException {
        System.out.println("숫자를 입력해 주세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Integer> UserNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            UserNumber.add(num);
        }
        return UserNumber;
    }
}
