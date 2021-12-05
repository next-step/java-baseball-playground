import java.util.Scanner;

public class Player {

    private int num;

    Player() {
        setNumber();
    }

    private void setNumber() {

        while(true){
            System.out.print("세 자리의 중복되지 않은 수를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            String playerStrNum = scanner.nextLine();
            int playerNum = Integer.parseInt(playerStrNum);

            if(ValidationUtils.isProper(playerNum)) {
                this.num = playerNum;
                break;
            }
        }
    }

    public int getNumber() {
        return this.num;
    }
}