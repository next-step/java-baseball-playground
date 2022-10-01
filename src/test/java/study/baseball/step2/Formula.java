package study.baseball.step2;
import static study.baseball.step2.Constant.FORMULA_SPLITTER;

public class Formula {

    private String[] formula;

    Formula(String formula){
        this.formula = formula.split(FORMULA_SPLITTER);
    }

    String[] getFormula(){
        return formula;
    }
}
