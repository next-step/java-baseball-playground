import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class InputService {
    private LinkedHashSet<Integer> tmpInputNumbers = new LinkedHashSet<>();
    private ArrayList<Integer> finalInputNumbers;
    private boolean isValid = false;
    InputView view = new InputView();

    ArrayList<Integer> startConsole() throws IOException {
        while(!isValid){
            tmpInputNumbers.clear();
            String[] input = view.printRequestMessage();
            System.out.println(Arrays.toString(input));
            isValid = validateInput(input);
        }
        System.out.println("inputNumbers = " + tmpInputNumbers.toString());
        finalInputNumbers = new ArrayList<>(tmpInputNumbers);
        return finalInputNumbers;
    }
    boolean validateInput(String[] input) {
        try{
            validateSize(input);
            validateType(input);
            validateSize(tmpInputNumbers);
        }catch(NumberCountException | NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void validateSize(String[] input) {
        if(input.length!=3)
            throw new NumberCountException("입력은 세자리만..");
    }

    private void validateSize(LinkedHashSet<Integer> input) {
        if(input.size()!=3)
            throw new NumberCountException("중복된 숫자..있을지도..");
    }

    private void validateType(String[] before) throws NumberFormatException{
        Arrays.asList(before).stream()
                .forEach(num -> tmpInputNumbers.add(Integer.parseInt(num)));
    }

}
