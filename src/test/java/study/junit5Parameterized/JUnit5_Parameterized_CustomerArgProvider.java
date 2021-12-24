package study.junit5Parameterized;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5_Parameterized_CustomerArgProvider implements ArgumentsProvider {


    public static boolean isBlank(String input){
        return input == null || input.trim().isEmpty();
    }
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of((String) null),
                Arguments.of(""),
                Arguments.of("   ")
        );
    }
    @ParameterizedTest
    @ArgumentsSource(JUnit5_Parameterized_CustomerArgProvider.class)
    void isBlank_ShouldReturnTrueForNullOrBlankStringsArgProvider(String input) {
        assertTrue(JUnit5_Parameterized_CustomerArgProvider.isBlank(input));
    }

}
