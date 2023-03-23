package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MorseCodeEncoderTest {

    private final MorseCodeDictionary dictionary = new MorseCodeDictionary();
    private final MorseCodeEncoder encoder = new MorseCodeEncoder(dictionary);

    @Test
    void testEncodeSuccess() {
        // given
        final String text = "HEY SDA";
        final String expectedCode = ".... . -.--   ... -.. .-";

        // when
        final String actualCode =  encoder.encode(text);

        // then
        Assertions.assertEquals(expectedCode, actualCode);
    }
}