package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
class InputReaderTest {

    @Mock
    private Scanner scanner;

    @InjectMocks
    private InputReader inputReader;

//    private final Scanner scanner = Mockito.mock(Scanner.class);
//    private final InputReader inputReader = new InputReader(scanner);

    @BeforeEach
    void reset() {
        Mockito.reset(scanner);
    }

    @Test
    void testReadStringSuccess() {
        // given
        final String expectedOutput = "Text";
        Mockito.when(scanner.nextLine()).thenReturn(expectedOutput);

        // when
        final String actualOutput = inputReader.readString();

        // then
        Mockito.verify(scanner).nextLine();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testReadStringsSuccess() {
        // given
        final int invocations = 2;
        final String input1 = "Text1";
        final String input2 = "Text2";
        final List<String> expectedList = List.of(input1, input2);

        Mockito.when(scanner.nextLine()).thenReturn(input1)
                .thenReturn(input2);

        // when
        List<String> actualList = inputReader.readStrings(invocations);

        // then
        Mockito.verify(scanner, Mockito.times(invocations)).nextLine();
        Assertions.assertIterableEquals(expectedList, actualList);
    }


    @Test
    void testReadStringException() {
        // when
        Executable executable = () -> inputReader.readString(true);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, executable);
        Mockito.verifyNoInteractions(scanner);
    }

    @Test
    void testReadStringNoException() {
        // given
        final String expectedOutput = "Text";
        Mockito.when(scanner.nextLine()).thenReturn(expectedOutput);

        // when
        String  actualOutput =  inputReader.readString(false);

        // then
        Mockito.verify(scanner).nextLine();
        Mockito.verifyNoMoreInteractions(scanner);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}