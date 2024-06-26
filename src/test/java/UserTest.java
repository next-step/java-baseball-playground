import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User();
    @Test
    void getUserArr() {
        String userInputArr = "453";
        int[]userInput = user.getUserArr(userInputArr);
        assertTrue(user.isPermitDifferent(userInput));
        assertTrue(user.isPermitDifferent(userInput));
        assertTrue(user.isPermitNum(userInput));
    }


}