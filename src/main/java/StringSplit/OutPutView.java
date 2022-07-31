package StringSplit;

import java.util.Arrays;

public class OutPutView {

    private String [] calculatorType = {"+","-","*","/"};
    private String regex = "\\d+";

    public int calculator(String value){
        String [] values = value.split(" ");
        int calculatorResult = 0;
        int typeIndex = 0;

        for(int i = 0 ; i < values.length; i++){
            if(i == 0 ){
                if(!values[i].matches(regex)){
                    throw new RuntimeException("first index value is number");
                }
                calculatorResult = Integer.parseInt(values[i]);

                continue;
            }

            if(calculatorTypeConfirm(values[i])){

                typeIndex = Arrays.asList(calculatorType).indexOf(values[i]);

            }else{
                System.out.println(values[i]);
                if(calculatorType[typeIndex].equals("+")){
                    calculatorResult = plus(calculatorResult,Integer.parseInt(values[i]));
                }else if(calculatorType[typeIndex].equals("-")){
                    calculatorResult = minus(calculatorResult,Integer.parseInt(values[i]));
                }else if(calculatorType[typeIndex].equals("*")){
                    calculatorResult = multiply(calculatorResult,Integer.parseInt(values[i]));
                }else if(calculatorType[typeIndex].equals("/")){
                    calculatorResult = division(calculatorResult,Integer.parseInt(values[i]));
                }
            }

        }


        return calculatorResult;
    }

    private boolean calculatorTypeConfirm(String type){

        for(String calculator : calculatorType){
            if(calculator.equals(type)) return true;
        }

        return false;
    }

    public int plus(int firstValue , int secondValue){
        return firstValue + secondValue;
    }

    public int minus(int firstValue , int secondValue){
        return firstValue - secondValue;
    }

    public int multiply(int firstValue , int secondValue){
        return firstValue * secondValue;
    }

    public int division(int firstValue , int secondValue){
        if(firstValue == 0){
            throw new RuntimeException("do not divsion. firstValue is 0");
        }
        return firstValue / secondValue;
    }
}
