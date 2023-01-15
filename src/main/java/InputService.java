import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class InputService {
    private LinkedHashSet<Integer> inputNumbers = new LinkedHashSet<>();
    private boolean isValid = false;
    InputView view = new InputView();

    void start() throws IOException {
        while(!isValid){
            inputNumbers.clear();
            String[] input = view.printRequestMessage();
            System.out.println(Arrays.toString(input));
            isValid = validateInput(input);
        }
        System.out.println("while 끝?!");
    }
    boolean validateInput(String[] input) {
        try{
            validateSize(input);
            validateType(input);
            validateSize(inputNumbers);
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
                .forEach(num -> inputNumbers.add(Integer.parseInt(num)));
    }

}
