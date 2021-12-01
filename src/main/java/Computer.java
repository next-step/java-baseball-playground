import javax.swing.*;

public class Computer {
    private final int number;

    Computer() {
        this.number = setRandomNum();
    }

    private int setRandomNum() {
        int randomNum = (int)(Math.random() * 1000);
        while(!ValidationUtils.isValid(randomNum) || ValidationUtils.isDuplicated(randomNum)) {
            randomNum = (int)(Math.random() * 1000);;
        }
        return randomNum;
    }

    public int getNumber () {
        return this.number;
    }
}
