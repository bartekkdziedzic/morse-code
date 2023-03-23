package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MorseCodeDecoder decoder;
        MorseCodeEncoder encoder;
        MorseCodeDictionary dictionary = new MorseCodeDictionary();

        try (Scanner scanner = new Scanner(System.in)) {
            String options = """
                    1 - Decode
                    2 - Encode
                    3 - Exit
                    """;
            String option;
            do {
                System.out.println("Please choose action: ");
                System.out.println(options);
                option = scanner.nextLine();

//                if ("1".equals(option)) {
//                    decoder = new MorseCodeDecoder(dictionary);
//                    System.out.println("Please enter Morse Code: ");
//                    String moseCode = scanner.nextLine();
//                    String decodedText = decoder.decode(moseCode);
//                    System.out.printf("Decoded text: %s%n", decodedText);
//                } else if ("2".equals(option)) {
//                    encoder = new MorseCodeEncoder(dictionary);
//                    System.out.println("Please enter text: ");
//                    String text = scanner.nextLine();
//                    String encodedText = encoder.encode(text);
//                    System.out.printf("Encoded text: %s%n", encodedText);
//                } else if ("3".equals(option)) {
//                    System.out.println("Good Bye!");
//                } else {
//                    System.err.println("Invalid operation!");
//                }

                switch (option) {
                    case "1" -> {
                        decoder = new MorseCodeDecoder(dictionary);
                        System.out.println("Please enter Morse Code: ");
                        String moseCode = scanner.nextLine();
                        String decodedText = decoder.decode(moseCode);
                        System.out.printf("Decoded text: %s%n", decodedText);
                    }
                    case "2" -> {
                        encoder = new MorseCodeEncoder(dictionary);
                        System.out.println("Please enter text: ");
                        String text = scanner.nextLine();
                        String encodedText = encoder.encode(text);
                        System.out.printf("Encoded text: %s%n", encodedText);
                    }
                    case "3" -> System.out.println("Good Bye!");
                    default -> System.err.println("Invalid operation!");
                }
            } while (!"3".equals(option));
        }
    }
}