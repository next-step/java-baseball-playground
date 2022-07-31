package StringSplit;

import java.util.Scanner;

public class InputView {

    public void setText(){
        Scanner scanner = new Scanner(System.in);

        String scannerText = scanner.nextLine();

        OutPutView outPutView = new OutPutView();

        int result = outPutView.calculator(scannerText);

        System.out.println(result);
    }
}
