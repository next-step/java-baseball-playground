package calculator.endpoint;

public class UserInterfaceExecutor {
    public void beforeStart() {
        System.out.println("> 계산기를 준비중입니다. 잠시만 기다려주세요!");
    }

    public void waitUserInput() {
        System.out.print("> 계산식을 입력해주세요!\n입력: ");
    }

    public void printResult(int result) {
        System.out.format("> 결과값을 알려드립니다.\n값:%s\n\n", result);
    }
}
