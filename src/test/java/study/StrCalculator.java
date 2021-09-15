package study;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StrCalculator {
    
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void scannerTest(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
       
        Queue<Integer> numbers = new LinkedList<>();
        Queue<String> operators = new LinkedList<>();
        
        Scanner scanner = new Scanner(System.in);
        
        String value = scanner.nextLine();
//        System.out.println(value);
        String[] values = value.split(" ");
        
        for(String v : values) {
            if(v.equals("+") || v.equals("*") || v.equals("/")) {
                operators.add(v);
            } else {
                numbers.add(Integer.parseInt(v));
            }
        }
        
//        System.out.println(numbers);
//        System.out.println(operators);
        
        
        int result = numbers.poll();
        
        while(!numbers.isEmpty()) {
            String op = operators.poll();
            if(op.equals("+")) {
                result += numbers.poll();
            } else if (op.equals("*")) {
                result *= numbers.poll();
            } else {
                result /= numbers.poll();
            }
        }
        
        System.out.println(result);
    }
    
    
    
}
