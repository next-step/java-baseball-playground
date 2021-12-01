import java.util.Scanner;

public class Player {

    private int num;

    Player() {
        setNumber();
    }

    private void setNumber() {

        int playerNum;

        System.out.print("세 자리 수를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String playerStrNum = scanner.nextLine();
        playerNum = Integer.parseInt(playerStrNum);

        if (!ValidationUtils.isValid(playerNum)) {
            System.out.println("세자리 숫자가 아닙니다. 다시 입력해주세요");
            this.setNumber();
            return;
        }

        if (ValidationUtils.isDuplicated(playerNum)) {
            System.out.println("숫자 중복이 있습니다. 다시 입력해주세요");
            this.setNumber();
            return;
        }

        this.num = playerNum;
    }

    public int getNumber() {
        return this.num;
    }
}