package baseboll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BaseballGame baseballGame = new BaseballGame(br);
        baseballGame.game();
    }
}
