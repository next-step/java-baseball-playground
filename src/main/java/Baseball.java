import java.util.Scanner;

public class Baseball {
    static final int TOTAL_NUMBERS = 3;
    private int ballCount = 0;
    private int strikeCount = 0;
    private int gameStatus = 1;
    private String solution;

    // gameStatus 필드값이 1일때만 계속 게임을 진행.
    // 숫자를 맞춘 뒤 2를 입력하면 게임이 종료됨
    private boolean isGameRunning() {
        return gameStatus == 1;
    }

    // while문으로 본격적인 게임을 진행하기 전에, setSolution을 이용하여
    // 정답을 정해두고 시작함.
    public void startGame() {
        final Scanner scanner = new Scanner(System.in);
        setSolution();
        while (isGameRunning()) {
            String input = getInputNumber(scanner);
            playGame(input);
            endOrRestartGameIfStrikeOut(scanner);
        }
    }
    // 기존의 볼, 스트라이크 숫자를 초기화 한 뒤, 업데이트
    // 업데이트된 볼, 스트라이크 수를 기반으로 메시지 출력

    private void playGame(String input) {
        resetBallAndStrikeCount();
        updateBallAndStrikeCount(input);
        System.out.println(getMessage());
    }

    // 게임이 종료되면(:삼진 아웃), 입력을 받아 gameStatus를 결정하며,
    // 기존의 정답을 다시 초기화하여 설정함.
    private void endOrRestartGameIfStrikeOut(Scanner scanner) {
        if (isGameEnded()) {
            gameStatus = restartOrExit(scanner);
            setSolution();
        }
    }

    //구현된 RandomNumber 클래스를 이용하여, 문자열로 된 정답을 설정한다.
    private void setSolution() {
        final RandomNumber randomNumber = new RandomNumber();
        this.solution = randomNumber.getRandomNumber();
    }

    private String getInputNumber(Scanner scanner) {
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }

    // 스트라이크, 볼 점수를 초기화 함
    private void resetBallAndStrikeCount() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    // 필드로 지정된 정답과, 입력된 값을 받아 볼, 스트라이크 수를 계산함
    private void updateBallAndStrikeCount(String input) {
        for (int i = 0; i < TOTAL_NUMBERS; i++) {
            updateCount(solution.charAt(i), input.charAt(i));
        }
    }

    // 두 문자열의 i번째 문자를 받아, 같으면 strike
    // 서로 다르면서, 정답지가 입력의 문자를 포함하면 ball
    private void updateCount(char solWord, char inputWord) {
        if (solWord == inputWord) {
            strikeCount++;
        } else if (solution.contains(String.valueOf(inputWord))) {
            ballCount++;
        }
    }

    // 삼진 아웃인 경우, 게임 종료 메시지를 보낸 뒤 게임이 종료되었다고 알림
    private boolean isGameEnded() {
        if (strikeCount == TOTAL_NUMBERS) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    // 게임을 새로 시작할지, 종료할지에 대한 상태값을 얻어냄
    private int restartOrExit(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    private String getMessage() {
        if (ballCount != 0 && strikeCount != 0) {
            return String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        }
        if (ballCount == 0 && strikeCount != 0) {
            return String.format("%d스트라이크", strikeCount);
        }
        if (ballCount != 0) {
            return String.format("%d볼", ballCount);
        }
        return "낫싱";
    }
}

