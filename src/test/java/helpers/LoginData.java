package helpers;

import helpers.testData.InputTestData;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class LoginData {
    private static Stream<Arguments> loginDetails(){
        return Stream.of(
                Arguments.of(InputTestData.getCorrectUserName(), InputTestData.getCorrectPassword()),
                Arguments.of(InputTestData.getGlitchUserName(), InputTestData.getCorrectPassword())
        );
    }

}
