package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readString() {
        return scanner.nextLine();
    }

    public String readString(boolean exception) {
        if (exception) {
            throw new IllegalArgumentException();
        }

        return scanner.nextLine();
    }

    public List<String> readStrings(int number) {

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            strings.add(input);
        }

        return strings;
    }
}
