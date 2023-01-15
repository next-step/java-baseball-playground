import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class InputView {

    String[] printRequestMessage() throws IOException {
        System.out.println("숫자를 입력해 주세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        System.out.println(Arrays.toString(input));
        return input;
    }

}
