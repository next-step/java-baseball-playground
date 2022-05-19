package stringcal;

import java.io.IOException;
import java.util.Scanner;

public class StringCalculator {

    StringCalculator stringCalculator;
    //더하기
    public int add(int i, int j){
        return i+j;
    }

    //빼기
    public int subtract(int i, int j){
        return i-j;
    }

    //곱하기
    public int multiply(int i, int j){
        return i*j;
    }

    //나누기(몫이 0일경우 Exception)
    public int divide(int i, int j) {
        try {
            return i / j;
        } catch (Exception e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
        return 0;
    }

    //문자열 자르는 메서드
    public String[] splitString(String str){
        return str.split("");
    }
}
