package baseball;

import baseball.util.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {
    private final List<Integer> numbers = new ArrayList<>();
    public ComputerNumbers(int size) {
        createComputerNumbers(size);
    }

    private void createComputerNumbers(int size){
        while (numbers.size() < size){
            add(NumberUtils.createRandomNumber(9));
        }
    }

    private void add(int number){
        if( !numbers.contains(number) ){
            numbers.add(number);
        }
    }

    public boolean isSize(int size) {
        return numbers.size() == size;
    }

    public List<Integer> getResult(){
        return numbers;
    }
}
