package calculator.endpoint;

import calculator.domain.Calculator;
import calculator.domain.UserInputReceiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorMainExecutor {

    public static final String EXIT_KEYWORD = "종료";

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void start(Calculator calculator, UserInputReceiver receiver, UserInterfaceExecutor uiExecutor) throws IOException {
        uiExecutor.beforeStart();

        while(true) {
            uiExecutor.waitUserInput();
            String input = bufferedReader.readLine();

            if(isExitKeyword(input)){
                break;
            }

            receiver.receive(input, " ");
            uiExecutor.printResult(calculator.calculate());
        }
    }

    private boolean isExitKeyword(String inputString) {
        return inputString.equals(EXIT_KEYWORD);
    }

    public static void main(String[] args) throws IOException {
        CalculatorMainExecutor calculatorMainExecutor = new CalculatorMainExecutor();
        UserInputReceiver userInputReceiver = new UserInputReceiver();
        Calculator calculator = new Calculator(userInputReceiver);

        calculatorMainExecutor.start(calculator, userInputReceiver, new UserInterfaceExecutor());
    }
}
