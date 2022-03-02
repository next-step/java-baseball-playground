package study;

public class Formula {
    private String formula;

    public Formula(String formula) {
        this.formula = formula;
    }

    String[] splitFormula() {
        return formula.split(" ");
    }
}
