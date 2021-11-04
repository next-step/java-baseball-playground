package baseball.view;

import baseball.model.view_interface.OutputView;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printJudgement(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printExceptionMessage(String msg) {
        System.out.println(msg);
    }
}
