package input;

import java.util.Arrays;

public enum GAME_PROGRESS_STATUS {
    PROGRESS(1)
    , TERMINATE(2)
    ;

    private int inputCode;

    GAME_PROGRESS_STATUS(int inputCode) {
        this.inputCode = inputCode;
    }

    public int getInputCode() {
        return inputCode;
    }

    public static GAME_PROGRESS_STATUS getGameProgressByInputCode(int inputCode) {
        return Arrays.stream(GAME_PROGRESS_STATUS.values())
                .filter(status -> status.getInputCode() == inputCode)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static boolean isProgress(GAME_PROGRESS_STATUS status){
        return status == PROGRESS;
    }
}
