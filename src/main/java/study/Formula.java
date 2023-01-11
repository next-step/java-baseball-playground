package study;

public class Formula {

    String[] formulaArray;

    public Formula(String stringFormula) {
        this.formulaArray = stringFormula.split(" ");
    }

    public String getValue(int i) {
        return formulaArray[i];
    }

    public int getLength() {
        return formulaArray.length;
    }

    public Boolean isValidate() {
        Boolean isCalculable = true;
        if(formulaArray.length % 2 != 1) {
            return false;
        }
        for(int i = 2; i < formulaArray.length; i += 2) {
            isCalculable = this.isCalculable(isCalculable, formulaArray[i - 2], formulaArray[i - 1], formulaArray[i]);
        }
        return isCalculable;
    }

    private Boolean isCalculable(Boolean isCalculable, String firstOperand, String operator, String secondOperand) {
        if(isCalculable == false) return false;
        if(isNumeric(firstOperand) == false || FourOperators.get(operator) == null || isNumeric(secondOperand) == false) {
            return false;
        }
        return true;
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}
