package baseball;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutPutView {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void showResult(BaseBall baseBall, PlayResult result) {
        try {
            if (result.isNotThing()) {
                bw.write("낫싱\n");
                bw.flush();
                return;
            }
            if (result.getBallCount() > 0) {
                bw.write(result.getBallCount() + "볼 ");
            }
            if (result.getStrikeCount() > 0) {
                bw.write(result.getStrikeCount() + "스트라이크");
            }
            bw.write("\n");

            if (result.EndGame()) {
                baseBall.setEnd(true);
                bw.write("3개의 숫자를 모두 맞히셨습니다 ! 게임 종료");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
