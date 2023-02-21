package racing.console;

import racing.core.OutputView;

public class ConsoleOutputView implements OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final StringBuilder buffer = new StringBuilder();

    @Override
    public void print(String message) {
        buffer.append(message);
    }

    @Override
    public void println(String message) {
        buffer.append(message);
        buffer.append(NEW_LINE);
    }

    @Override
    public void flush() {
        System.out.print(buffer);
        buffer.setLength(0);
    }
}
