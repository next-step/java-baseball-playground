import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class InputView {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] printRequestMessage() throws IOException {
        System.out.println("숫자를 입력해 주세요 : ");
        String[] input = br.readLine().split("");
        return input;
    }

    String restartMessage() throws IOException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return br.readLine();
    }

}
