import javax.swing.*;

public class Computer {
    private final int number;

    Computer() {
        this.number = getRandomNum();
    }

    private int getRandomNum() {
        int randomNum = (int)(Math.random() * 1000);
        while(!ValidationUtils.validNum(randomNum) || ValidationUtils.inspectDuplicate(randomNum)) {
            randomNum = (int)(Math.random() * 1000);;
        }
        return randomNum;
    }

    public int getNumber () {
        return this.number;
    }
}
