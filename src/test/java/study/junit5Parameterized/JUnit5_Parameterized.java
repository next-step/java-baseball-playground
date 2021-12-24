package study.junit5Parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class JUnit5_Parameterized {

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }


    @DisplayName("can check 2 case : a source of arguments / a way to access them")
    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5,-3, 15, Integer.MAX_VALUE})
    void isOdd_ShouldReturnTrueForOddNumbers(int number){
        assertTrue(JUnit5_Parameterized.isOdd(number));
    }

    public static boolean isBlank(String input){
        return input == null || input.trim().isEmpty();
    }

    @DisplayName("Junit will run test two times and each time assigns one arguments from the array to the method parameter")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input){
        assertTrue(JUnit5_Parameterized.isBlank(input));
    }


    @ParameterizedTest
    @EmptySource
    void isBlank_ShouldReturnTrueForEmptyStrings(String input){
        assertTrue(JUnit5_Parameterized.isBlank(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isBlank_ShouldReturnTrueNullAndEmptyStrings(String input){
        assertTrue(JUnit5_Parameterized.isBlank(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(String input){
        assertTrue(JUnit5_Parameterized.isBlank(input));
    }








}
