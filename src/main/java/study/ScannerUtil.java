package study;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerUtil {

    private String input;

    private InputStream in;

    private Scanner scanner;


    public ScannerUtil(String str) {
        this.input = str;
        getByteArrayInputStream();
        scanner = new Scanner(in);
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    private void getByteArrayInputStream() {
        in = new ByteArrayInputStream(input.getBytes());
    }

}
