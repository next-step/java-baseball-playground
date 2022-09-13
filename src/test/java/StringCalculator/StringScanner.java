package StringCalculator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringScanner {

    private Scanner scanner;
    private PrintStream printStream;

    public StringScanner(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }


    public static void main(String[] args){

        StringScanner ss = new StringScanner(System.in, System.out);
        ss.printStream.print("input: ");
        String value = ss.scanner.nextLine();

        Calculator cal = new Calculator();
        cal.parseInt(value);

    }

}
