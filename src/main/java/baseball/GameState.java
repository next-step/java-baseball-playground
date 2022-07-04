package baseball;

public interface GameState {
    void viewUpdate();
    String readInput();
    void evaluatePlayerData(String input);
    void nextState();
}
