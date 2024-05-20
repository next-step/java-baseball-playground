package gameResult;


public class GameResultVerifyService {

    public GameResult verify(int[] answer, int[] input){

        StrikeCountService strikeCountService = new StrikeCountService();
        int strike = strikeCountService.countStrike(answer, input);

        BallCountService ballCountService = new BallCountService();
        int ball = ballCountService.ballCount(answer, input);

        return new GameResult(ball, strike);
    }

}
