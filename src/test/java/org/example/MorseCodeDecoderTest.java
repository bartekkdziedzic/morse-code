package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MorseCodeDecoderTest {

    private final MorseCodeDictionary dictionary = new MorseCodeDictionary();
    private final MorseCodeDecoder decoder = new MorseCodeDecoder(dictionary);

    public static Stream<Arguments> paramsProvider() {
        return Stream.of(
                //  String input, String expectedCode
                Arguments.of("SDA", "... -.. .-"),
                Arguments.of("SOS", "... --- ..."),
                Arguments.of("JAVA", ".--- .- ...- .-"),
                Arguments.of("HEY SDA", ".... . -.--   ... -.. .-"),
                Arguments.of("JAVA ROCKS", ".--- .- ...- .-   .-. --- -.-. -.- ..."),
                Arguments.of("I LOVE JAVA", "..   .-.. --- ...- .   .--- .- ...- .-"),
                Arguments.of("SOFTWARE DEVELOPMENT ACADEMY", "... --- ..-. - .-- .- .-. .   -.. . ...- . .-.. --- .--. -- . -. -   .- -.-. .- -.. . -- -.--")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsProvider")
    void testDecodeHappyPath(String expectedText, String input) {

        // when
        final String actualText = decoder.decode(input);

        // then
        Assertions.assertEquals(expectedText, actualText);
    }
}