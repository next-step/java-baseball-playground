import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();
        String[] split = request.split(" ");
        LinkedList<String> numbers = responseNumber(split);

        LinkedList<String> operations = responseOperation(split);
        LinkedList<Integer> parseNumbers = parseInts(numbers);

    }


    /**
     * 숫자 배열만 반환 하는 메서드
     */
    public static LinkedList<String>  responseNumber(String[] split) {
        LinkedList<String> strings = new LinkedList<>();
        for(int i =0; i<split.length;i++){
            if(i == 0 || i % 2 ==0){
                strings.add(split[i]);
            }
        }
        return strings;
    }

    /**
     * 계산 배열만 반환하는 메서드
     */
    public static LinkedList<String> responseOperation(String[] split){
        LinkedList<String> operations = new LinkedList<>();
        for(int i =0; i<split.length;i++){
            if(i % 2 ==1){
                operations.add(split[i]);
            }
        }
        return operations;
    }

    /**
     * 모든 숫자를 파싱하는 메서드
     */
    public static LinkedList<Integer> parseInts (List<String> numbers){
        LinkedList<Integer> integers = new LinkedList<>();
        for(String number : numbers){
            integers.add(Integer.parseInt(number));
        }
        return integers;
    }


}
