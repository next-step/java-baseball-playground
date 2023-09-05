public class BallClassifier {

    public boolean isStrike(Balls answerBalls, Ball tryBall) {
        return answerBalls.getBalls().get(tryBall.getPosition()-1).getNumber() == tryBall.getNumber();
    }

    public boolean isBall(Balls answerBalls, Ball tryBall) {
        return answerBalls.isDuplicateBall(tryBall.getNumber());
    }
}
