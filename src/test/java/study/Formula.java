package study;

public class Formula {
    private String[] formula;

    public Formula(String formula) {
        this.formula = formula.split(" ");
    }

    public String[] getFormula() {
        return formula;
    }
}
