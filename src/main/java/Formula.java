public class Formula {
    private static final String FORMULA_DELIMITER = " ";
    private final String[] formula;

    public Formula(String formula) {
        this.formula = formula.split(FORMULA_DELIMITER);
    }

    public String[] getFormula() {
        return formula;
    }
}


