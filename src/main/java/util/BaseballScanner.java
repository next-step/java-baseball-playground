package util;

import java.util.Scanner;

public class BaseballScanner implements ScannerUtil {
    @Override
    public String nextLine() {
        return new Scanner(System.in).nextLine();
    }
}