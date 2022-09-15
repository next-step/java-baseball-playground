package StringCalculator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StringScanner {

    private Scanner scanner;
    private PrintStream printStream;

    public StringScanner(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }


    public static void main(String[] args){

        //사용자에게서 값을 받아옴
        StringScanner ss = new StringScanner(System.in, System.out);
        ss.printStream.print("input: ");
        String value = ss.scanner.nextLine();

        //1. Calculator 클래스에서 사용자에게 받아온 값을 파싱
        //2. Calculator 클래스에서 계산식 수행
        Calculator cal = new Calculator();
        cal.operator(cal.parseInt(value), cal.parseForms(value));

    }

}
