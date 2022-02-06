import java.util.Scanner;

public class BaseBallGameMain {
	static BaseBallGameManager baseBallGameManager = new BaseBallGameManager();

	public static void main(String[] args) {
		gameStart();
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		while (scanner.nextInt() == 1) {
			gameStart();
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		}
	}

	private static void gameStart() {
		baseBallGameManager.initGame();

		boolean isGameFinished = false;
		while (!isGameFinished) {
			System.out.print("숫자를 입력해 주세요 : ");
			Scanner scanner = new Scanner(System.in);
			Integer inputValue = scanner.nextInt();

			ResultView resultView = baseBallGameManager.makeGameResult(new InputView(inputValue));
			resultView.printGameResult();
			isGameFinished = gameResultUpdate(resultView);
		}
	}

	private static Boolean gameResultUpdate(ResultView resultView) {
		if (resultView.isResultCorrectAnswer()) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}
}
