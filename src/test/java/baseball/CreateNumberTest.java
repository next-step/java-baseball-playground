package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateNumberTest {

    @Test
    void createNumber() {
        CreateNumber createNumber = new CreateNumber();
        List<Integer> numberList = createNumber.makeRandomNumbers();
        System.out.println(numberList);
        assertEquals(3, numberList.size());
    }

}