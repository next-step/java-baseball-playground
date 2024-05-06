package com.ui;

import java.util.Scanner;

public class Input {
    private static Scanner scanner;

    public static String receiveNumberInput(){
        scanner = new Scanner(System.in);
        Output.printRequestNumberInput();
        return scanner.nextLine();
    }

    public static String receiveResumeInput(){
        scanner = new Scanner(System.in);
        Output.printRequestResumeInput();
        return scanner.nextLine();
    }

}
