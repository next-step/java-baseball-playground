import java.util.Scanner;

public class InputView {
    static String input;
    static Scanner scanner = new Scanner(System.in);

    public String getInput(){
        System.out.print("숫자를 입력해 주세요 : ");
        input = scanner.nextLine();
        return input;
    }


}
