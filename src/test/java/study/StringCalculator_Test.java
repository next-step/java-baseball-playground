package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculator_Test {
    String str = "2 + 3 * 4 / 2";
    String[] strArray = str.split(" ");

    int firstValue = Integer.parseInt(strArray[0]);    // 2
    int secondValue = 0;

    for(int i = 0; i < strArray.length; i++){

    }

    public int plus(int a, int b){
        return a + b;
    }

    public int minus(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b){
        return a / b;
    }
}
