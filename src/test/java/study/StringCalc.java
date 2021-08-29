package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

public class StringCalc {
    String value = null;
    String[] values = null;

    @BeforeEach
    void setUp() {
        Calculator calculator = new Calculator();
        calculator.inputValue();
        value = calculator.getStr();
    }

    @Test
    void 문자열_계산기() {
        values = value.split(" ");

        Queue<Integer> valueList = new LinkedList<>();
        Queue<String> signList = new LinkedList<>();

        for (String s : values) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                signList.add(s);
            }else
                valueList.add(Integer.parseInt(s));
        }

        //예를 들어 value : "2 + 3 * 4 / 2" , values : 2,+,3,*,4,/,2
        //valueList : 2,3,4,2 , signList : +,*,/
        int firstValue = valueList.poll();

        while (!valueList.isEmpty()) {
            String op = signList.poll();
            if (op.equals("+")) {
                firstValue += valueList.poll();
            } else if (op.equals("-")) {
                firstValue -= valueList.poll();
            } else if (op.equals("*")) {
                firstValue *= valueList.poll();
            } else {
                firstValue /= valueList.poll();
            }
        }

        Assertions.assertThat(firstValue).isEqualTo(10);
    }

    static class Calculator {
        private String str;

        public void inputValue() {
            String data = "2 + 3 * 4 / 2";
            InputStream stdin = System.in;
            try {
                System.setIn(new ByteArrayInputStream(data.getBytes()));
                Scanner scanner = new Scanner(System.in);
                str = scanner.nextLine();
            } finally {
                System.setIn(stdin);
            }
        }

        public String getStr() {
            return str;
        }
    }
}
