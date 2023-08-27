package baseboll.myTrial.second.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private final BufferedReader br;

    public InputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getInput() throws IOException {
        System.out.println("숫자를 입력 해 주세요");
        String input = br.readLine();
        if (!isProperInput(input)) {
            getInput();
        }
        return input;
    }

    public boolean wantContinue() throws IOException {
        String input = br.readLine();
        return input.equals("1");
    }

    public boolean isProperInput(String s) {
        if (s.length() != 3) {
            System.out.println("3자리 숫자를 입력해주세요");
            return false;
        }
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요");
            return false;
        }
        return true;
    }
}
