import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultViewTest {
    ResultView resultView;
    @Test
    void 결과출력테스트() {
        Round round = new Round(0,3,false);
        resultView = new ResultView(round);
        resultView.printResult();
    }
}