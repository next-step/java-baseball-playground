package study;

public class CalculatorToString {
    public int add(String text){
        if(text == null || text.isEmpty()){
            return 0;
        }
        return Integer.parseInt(text);
    }

}
