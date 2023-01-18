public class ResultView {

    Round round;
    boolean isRight = false;

    public ResultView(Round round) {
        this.round = round;
    }

    boolean setRight() {
        if(round.getStrike()==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    void printResult() {
        if(round.isOut()) {
            System.out.println("아웃!");
            return;
        }
        if(round.getBall()!=0&&round.getStrike()!=0){
            System.out.println(round.getBall()+"볼 "+round.getStrike()+"스트라이크");
            return;
        }
        if(round.getBall()>0)
            System.out.println(round.getBall()+"볼");

        if(round.getStrike()>0)
            System.out.println(round.getStrike()+"스트라이크");
    }


}
